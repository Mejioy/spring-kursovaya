package ru.kafpin.firsttt.repositories;

import ru.kafpin.firsttt.entities.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    Service findByName(String name);
}
