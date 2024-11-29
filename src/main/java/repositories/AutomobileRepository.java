package repositories;

import entities.Automobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends CrudRepository<Automobile, Long> {
}
