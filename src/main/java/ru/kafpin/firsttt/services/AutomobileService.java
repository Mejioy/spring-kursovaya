package ru.kafpin.firsttt.services;

import ru.kafpin.firsttt.entities.Automobile;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kafpin.firsttt.repositories.AutomobileRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AutomobileService {
    @Autowired
    private AutomobileRepository automobileRepository;

    public List<Automobile> getAllAutomobiles() {
        return (List<Automobile>) automobileRepository.findAll();
    }

    public Automobile getAutomobileById(Long id) {
        Optional<Automobile> automobile = automobileRepository.findById(id);
        if(automobile.isEmpty()){
            throw new EntityNotFoundException("Автомобиль не найден");
        }
        return automobile.get();
    }

    public void deleteAutomobileById(Long id) {
        if (automobileRepository.existsById(id))
            automobileRepository.deleteById(id);
    }

    public Automobile addEditAutomobile(Automobile automobile) {
        return automobileRepository.save(automobile);
    }

    ///Specific methods
    public Automobile getAutomobileByGosnumber(String gosnumber){
        return automobileRepository.findByGosnumber(gosnumber);
    }

    public List<Automobile> getAllAutomobilesByClientPhone(String phone) {
        return (List<Automobile>) automobileRepository.findByClientPhone(phone);
    }

    public List<Automobile> getAllAutomobilesByClientId(Long id) {
        return (List<Automobile>) automobileRepository.findByClientId(id);
    }
}