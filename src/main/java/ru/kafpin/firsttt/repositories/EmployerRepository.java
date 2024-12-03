package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Long> {
    Employer findByPhone(String phone);
}
