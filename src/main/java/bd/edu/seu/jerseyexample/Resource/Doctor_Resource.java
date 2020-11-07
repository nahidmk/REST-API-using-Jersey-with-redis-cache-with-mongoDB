package bd.edu.seu.jerseyexample.Resource;

import bd.edu.seu.jerseyexample.Model.Doctor;
import bd.edu.seu.jerseyexample.Service.Doctor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/doctor")
@Produces({MediaType.APPLICATION_JSON})
public class Doctor_Resource  {

    @Autowired
    private Doctor_Service doctor_service;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<Doctor> Save_Doctor(Doctor doctor)
    {
        Doctor doctor1 = doctor_service.Save_Doctor(doctor);
        return ResponseEntity.ok(doctor1);
    }

    @GET
    public ResponseEntity<List<Doctor>> Find_All()
    {
        return ResponseEntity.ok(doctor_service.All_Doctors());
    }

    @Path("/{id}")
    @GET
    public ResponseEntity<Doctor> Find_By_Id(@PathParam("id") long id)
    {
        return ResponseEntity.ok(doctor_service.Find_By_Id(id));
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<Doctor> Update_Doctor(Doctor doctor)
    {
        return ResponseEntity.ok(doctor_service.Update_Doctor(doctor));
    }
    @Path("/{id}")
    @DELETE
    public ResponseEntity<Doctor> Delete_Doctor(@PathParam("id") long id)
    {
        return ResponseEntity.ok(doctor_service.Delete_Doctor(id));
    }

}
