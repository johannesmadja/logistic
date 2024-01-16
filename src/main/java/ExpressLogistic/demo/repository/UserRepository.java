package ExpressLogistic.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ExpressLogistic.demo.domaine.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}