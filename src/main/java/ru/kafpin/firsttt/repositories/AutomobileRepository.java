package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Automobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutomobileRepository extends CrudRepository<Automobile, Long> {
    List<Automobile> findByClientPhone(String phone);
    List<Automobile> findByClientId(Long id);
    Automobile findByGosnumber(String gosnumber);
}