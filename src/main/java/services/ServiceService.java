package services;

import entities.Employer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import entities.Service;
import repositories.EmployerRepository;
import repositories.ServiceRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    public void setServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return (List<Service>) serviceRepository.findAll();
    }

    public Service getServiceById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        if(service.isEmpty()){
            throw new EntityNotFoundException("Услуга не найдена");
        }
        return service.get();
    }

    public void deleteServiceById(Long id) {
        if (serviceRepository.existsById(id))
            serviceRepository.deleteById(id);
    }

    public Service addEditService(Service service) {
        return serviceRepository.save(service);
    }
}
