package uz.nt.uzumnt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String gender;
    private String email;
    private Date birthDate;
}
