package repositories;

import entities.ProvidedService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServiceRepository extends CrudRepository<ProvidedService, Long> {
}
