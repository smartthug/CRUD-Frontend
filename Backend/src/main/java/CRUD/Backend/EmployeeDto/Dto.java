package CRUD.Backend.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
}
