package bd.edu.seu.jerseyexample.Config;

import bd.edu.seu.jerseyexample.Resource.Doctor_Resource;
import bd.edu.seu.jerseyexample.Resource.Patient_Resource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class Doctor_Config extends ResourceConfig {
    public Doctor_Config() {
        register(Doctor_Resource.class);
        register(Patient_Resource.class);
    }
}
