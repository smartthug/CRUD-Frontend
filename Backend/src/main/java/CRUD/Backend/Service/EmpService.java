package CRUD.Backend.Service;

import CRUD.Backend.EmployeeDto.Dto;
import CRUD.Backend.Entity.Emp;
import CRUD.Backend.Exception.ResourceNotFound;
import CRUD.Backend.Mapper.EmpMapper;
import CRUD.Backend.Repository.EmployeeReposit;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmpService implements EmployeeService{

    private EmployeeReposit employeeReposit;
    public EmpService(EmployeeReposit employeeReposit) {
        this.employeeReposit = employeeReposit;
    }
    @Override
    public Dto createEmp(Dto dto) {

        Emp employee= EmpMapper.mapToEntity(dto);
        Emp createEmp=employeeReposit.save(employee);
        return EmpMapper.mapToDto(createEmp);
    }

    @Override
    public Dto getEmp(Long employeeid) {
        Emp getemp=employeeReposit.findById(employeeid).orElseThrow(()->new ResourceNotFound("Employee not Exits"+employeeid));
        return EmpMapper.mapToDto(getemp);

    }

    @Override
    public List<Dto> getallemp() {
        List<Emp> getallemployee=employeeReposit.findAll();
        return getallemployee.stream().map((employees)->EmpMapper.mapToDto(employees)).collect(Collectors.toList());

    }

    @Override
    public void delete(Long employeeid) {
        Emp del=employeeReposit.findById(employeeid).orElseThrow(()->new ResourceNotFound("Employee not found "+employeeid));
        employeeReposit.deleteById(employeeid);
    }

    @Override
    public Dto update(Long employeeid, Dto dto) {
        Emp updateemp=employeeReposit.findById(employeeid).orElseThrow(()->new ResourceNotFound("Employee not created"+employeeid));
        updateemp.setFirstname(dto.getFirstname());
        updateemp.setLastname(dto.getLastname());
        updateemp.setEmail(dto.getEmail());
        updateemp.setGender(dto.getGender());

        Emp updated=employeeReposit.save(updateemp);
        return EmpMapper.mapToDto(updated);
    }
}
