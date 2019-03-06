package repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.Log;

@Repository
public interface LogRepository extends CrudRepository <Log, Integer> {

}
