package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Automobile;
import ru.kafpin.firsttt.entities.ProvidedService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvidedServiceRepository extends CrudRepository<ProvidedService, Long> {
    List<Automobile> findByAutomobileGosnumber(String gosnumber);
}