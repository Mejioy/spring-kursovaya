package ru.kafpin.firsttt.services;

import ru.kafpin.firsttt.entities.ProvidedService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafpin.firsttt.repositories.ProvidedServiceRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProvidedServiceService {
    @Autowired
    private ProvidedServiceRepository providedServiceRepository;

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
}