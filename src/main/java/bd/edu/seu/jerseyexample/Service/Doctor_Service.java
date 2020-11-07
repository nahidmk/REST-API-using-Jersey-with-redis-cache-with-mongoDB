package bd.edu.seu.jerseyexample.Service;

import bd.edu.seu.jerseyexample.DAO.Doctor_DAO;
import bd.edu.seu.jerseyexample.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Doctor_Service {

    @Autowired
    private Doctor_DAO doctor_dao;

    public Doctor Save_Doctor(Doctor doctor)
    {
        doctor_dao.save(doctor);
        return doctor_dao.findById(doctor.getId());
    }

    @CachePut(cacheNames = "Doctor",key = "#doctor.id")
    public Doctor Update_Doctor(Doctor doctor)
    {
        doctor_dao.save(doctor);
        return doctor_dao.findById(doctor.getId());
    }

    public List<Doctor> All_Doctors()
    {
        return doctor_dao.findAll();
    }

    @Cacheable(cacheNames = "Doctor",key = "#id")
    public Doctor Find_By_Id(long id)
    {
        return doctor_dao.findById(id);
    }
    @CacheEvict(cacheNames = "Doctor", key = "#id")
    public Doctor Delete_Doctor(long id)
    {
        Doctor doctor = doctor_dao.findById(id);
        doctor_dao.deleteById(id);
        return doctor;
    }
}
