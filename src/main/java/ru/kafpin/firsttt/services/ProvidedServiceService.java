package ru.kafpin.firsttt.services;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import ru.kafpin.firsttt.entities.ProvidedService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafpin.firsttt.repositories.ProvidedServiceRepository;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProvidedServiceService {
    @Autowired
    private ProvidedServiceRepository providedServiceRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment environment;

    public List<ProvidedService> getAllProvidedServices() {
        return (List<ProvidedService>) providedServiceRepository.findAll();
    }

    public ProvidedService getProvidedServiceById(Long id) {
        Optional<ProvidedService> providedService = providedServiceRepository.findById(id);
        if(providedService.isEmpty()){
            throw new EntityNotFoundException("Оказанная услуга не найдена");
        }
        return providedService.get();
    }

    public void deleteProvidedServiceById(Long id) {
        if (providedServiceRepository.existsById(id))
            providedServiceRepository.deleteById(id);
    }

    public ProvidedService addEditProvidedService(ProvidedService providedService) {
        return providedServiceRepository.save(providedService);
    }

    public List<ProvidedService> getAllProvidedServicesFromTo(LocalDate from, LocalDate to){
        return providedServiceRepository.findAllByDateOfProvideBetween(from,to);
    }
    public List<ProvidedService> getAllProvidedServicesByAutomobileId(Long id){
        return providedServiceRepository.findByAutomobileId(id);
    }

    public String sendReport(LocalDate from, LocalDate to){
        List<ProvidedService> providedServices = getAllProvidedServicesFromTo(from,to);
        byte[] pdf = generatePdf(providedServices);
        sendEmailWithAttachment("Report from: "+from+" to: "+to,
                "report.pdf",pdf);
        return "PDF sent successfully";
    }

    public byte[] generatePdf(List<ProvidedService> providedServices){
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{
            InputStream fontStream = ProvidedServiceService.class.getClassLoader().getResourceAsStream("static/arial.ttf");
            if (fontStream == null) {
                throw new IOException("Font file not found");
            }

            Path tempFontPath = Files.createTempFile("arial", ".ttf");
            Files.copy(fontStream, tempFontPath, StandardCopyOption.REPLACE_EXISTING);

            BaseFont baseFont = BaseFont.createFont(tempFontPath.toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 12);
            PdfWriter.getInstance(document,out);
            document.open();
            for(ProvidedService providedService:providedServices){
                document.add(new Paragraph(providedService.repData(), font));
            }
            document.close();
            Files.delete(tempFontPath);
        }
        catch (DocumentException | IOException e){
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public void sendEmailWithAttachment(String message ,String attachmentName,byte[] attachment){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(environment.getProperty("spring.mail.username"));
            messageHelper.setTo(environment.getProperty("mail.to"));
            messageHelper.setSubject("Report");
            messageHelper.setText(message);
            messageHelper.addAttachment(attachmentName, new ByteArrayResource(attachment));
            mailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            e.printStackTrace();
        }
    }
}