package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Client;
import ru.kafpin.firsttt.entities.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Long> {
    Optional<Employer> findByPhoneAndStatusTrue(String phone);
    List<Employer> findByStatusTrue();
}