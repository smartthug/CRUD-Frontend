package CRUD.Backend.Service;

import CRUD.Backend.EmployeeDto.Dto;


import java.util.List;

public interface EmployeeService {
    Dto createEmp(Dto dto);

    Dto getEmp(Long employeeid);

    List<Dto> getallemp();

    void  delete(Long employeeid);

    Dto update(Long employeeid,Dto dto);
}
