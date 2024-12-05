package ru.kafpin.firsttt.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kafpin.firsttt.entities.Service;
import ru.kafpin.firsttt.repositories.ServiceRepository;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

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