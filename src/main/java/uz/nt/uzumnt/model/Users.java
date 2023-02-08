package uz.nt.uzumnt.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
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
    @GeneratedValue(generator = "seq_id")
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_ID", allocationSize = 1)
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String gender;
    private String email;
    private Date birthDate;
    private Short isActive;
}
