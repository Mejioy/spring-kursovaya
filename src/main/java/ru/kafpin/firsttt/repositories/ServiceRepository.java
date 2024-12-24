package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    Optional<Service> findByNameAndStatusTrue(String name);
    List<Service> findByStatusTrue();
}