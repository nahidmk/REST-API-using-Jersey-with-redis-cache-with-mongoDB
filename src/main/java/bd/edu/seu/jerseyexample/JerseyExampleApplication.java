package bd.edu.seu.jerseyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JerseyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JerseyExampleApplication.class, args);
    }

}
