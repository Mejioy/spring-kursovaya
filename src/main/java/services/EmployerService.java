package services;

import entities.Client;
import entities.Employer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.EmployerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    public void setEmployerRepository(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> getAllEmployers() {
        return (List<Employer>) employerRepository.findAll();
    }

    public Employer getEmployerById(Long id) {
        Optional<Employer> employer = employerRepository.findById(id);
        if(employer.isEmpty()){
            throw new EntityNotFoundException("Сотрудник не найден");
        }
        return employer.get();
    }

    public void deleteEmployerById(Long id) {
        if (employerRepository.existsById(id))
            employerRepository.deleteById(id);
    }

    public Employer addEditEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
}
