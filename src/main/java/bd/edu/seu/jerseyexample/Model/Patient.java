package bd.edu.seu.jerseyexample.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
@TypeAlias("Patient")
public class Patient implements Serializable {
    @Id
    private long id;
    private String name;
    private String disease;
}
