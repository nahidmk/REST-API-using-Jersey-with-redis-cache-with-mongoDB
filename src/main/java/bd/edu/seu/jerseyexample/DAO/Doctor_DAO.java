package bd.edu.seu.jerseyexample.DAO;

import bd.edu.seu.jerseyexample.Model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_DAO extends MongoRepository<Doctor, Long> {

    Doctor findById(long id);
}
