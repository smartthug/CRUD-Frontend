package CRUD.Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_name")
    private String firstname;

    @Column(name = "Last_name")
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column
    private String gender;
}
