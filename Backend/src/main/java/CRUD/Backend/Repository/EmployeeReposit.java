package CRUD.Backend.Repository;

import CRUD.Backend.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReposit extends JpaRepository <Emp,Long>
{
}
