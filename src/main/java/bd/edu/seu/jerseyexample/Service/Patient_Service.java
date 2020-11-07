package bd.edu.seu.jerseyexample.Service;

import bd.edu.seu.jerseyexample.DAO.Patient_DAO;
import bd.edu.seu.jerseyexample.Model.Doctor;
import bd.edu.seu.jerseyexample.Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Patient_Service {

    @Autowired
    private Patient_DAO patient_dao;

    public Patient Save_Patient(Patient patient)
    {
        patient_dao.save(patient);
        Patient doctor1 = patient_dao.findById(patient.getId());
        return doctor1;
    }

    @CachePut(cacheNames = "Patient",key = "#patient.id")
    public Patient Update_Patient(Patient patient)
    {
        patient_dao.save(patient);
        return patient_dao.findById(patient.getId());
    }

    public List<Patient> All_Patient()
    {
        return patient_dao.findAll();
    }

    @Cacheable(cacheNames = "Patient",key = "#id")
    public Patient Find_By_Id(long id)
    {
        return patient_dao.findById(id);
    }
    @CacheEvict(cacheNames = "Patient", key = "#id")
    public Patient Delete_Patient(long id)
    {
        Patient patient = patient_dao.findById(id);
        patient_dao.deleteById(id);
        return patient;
    }
}
