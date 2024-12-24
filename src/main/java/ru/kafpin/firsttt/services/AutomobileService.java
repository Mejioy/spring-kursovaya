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
        if (automobileRepository.existsById(id)){
            Automobile existsAutomobile = getAutomobileById(id);
            existsAutomobile.setStatus(false);
            automobileRepository.save(existsAutomobile);
        }
    }

    public Automobile addEditAutomobile(Automobile automobile) {
        if(automobile.getId()==null){
            automobile.setStatus(true);
        }
        else {
            deleteAutomobileById(automobile.getId());
            automobile.setId(null);
        }
        return automobileRepository.save(automobile);
    }

    ///Specific methods
    public List<Automobile> getAllAutomobilesByClientPhone(String phone) {
        return automobileRepository.findByClientPhone(phone);
    }

    public List<Automobile> getAllActualAutomobilesByClientPhone(String phone) {
        return automobileRepository.findByStatusTrueAndClientPhone(phone);
    }

    public Automobile getAutomobileByGosnumber(String gosnumber) {
        Optional<Automobile> automobile = automobileRepository.findByGosnumberAndStatusTrue(gosnumber);
        if(automobile.isEmpty()){
            throw new EntityNotFoundException("Автомобиль не найден");
        }
        return automobile.get();
    }

}