package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Automobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AutomobileRepository extends CrudRepository<Automobile, Long> {
    List<Automobile> findByClientId(Long id);
    Optional<Automobile> findByGosnumber(String gosnumber);
}