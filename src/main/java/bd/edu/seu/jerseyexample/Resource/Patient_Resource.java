package bd.edu.seu.jerseyexample.Resource;

import bd.edu.seu.jerseyexample.Model.Doctor;
import bd.edu.seu.jerseyexample.Model.Patient;
import bd.edu.seu.jerseyexample.Service.Doctor_Service;
import bd.edu.seu.jerseyexample.Service.Patient_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/patient")
@Produces({MediaType.APPLICATION_JSON})
public class Patient_Resource {
    @Autowired
    private Patient_Service patient_service;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<Patient> Save_Doctor(Patient patient)
    {
        Patient patient1 = patient_service.Save_Patient(patient);
        return ResponseEntity.ok(patient);
    }

    @GET
    public ResponseEntity<List<Patient>> Find_All()
    {
        return ResponseEntity.ok(patient_service.All_Patient());
    }

    @Path("/{id}")
    @GET
    public ResponseEntity<Patient> Find_By_Id(@PathParam("id") long id)
    {
        return ResponseEntity.ok(patient_service.Find_By_Id(id));
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<Patient> Update_Doctor(Patient patient)
    {
        return ResponseEntity.ok(patient_service.Update_Patient(patient));
    }
    @Path("/{id}")
    @DELETE
    public ResponseEntity<Patient> Delete_Doctor(@PathParam("id") long id)
    {
        return ResponseEntity.ok(patient_service.Delete_Patient(id));
    }
}
