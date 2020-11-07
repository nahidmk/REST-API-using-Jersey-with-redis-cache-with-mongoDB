package bd.edu.seu.jerseyexample.DAO;

import bd.edu.seu.jerseyexample.Model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patient_DAO extends MongoRepository<Patient,Long> {
    Patient findById(long id);
}
