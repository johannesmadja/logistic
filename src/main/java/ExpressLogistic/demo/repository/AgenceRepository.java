package ExpressLogistic.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ExpressLogistic.demo.domaine.Agence;

@Repository
public interface AgenceRepository extends CrudRepository<Agence, String> {
    
}
