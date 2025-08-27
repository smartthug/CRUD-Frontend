package CRUD.Backend.Controller;

import CRUD.Backend.EmployeeDto.Dto;
import CRUD.Backend.Service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class Empcontrol {

    @Autowired
    private EmployeeService service;

    //Add employee
    @PostMapping
    public ResponseEntity<Dto> createEmp(@RequestBody Dto dto)
    {
     Dto saved=service.createEmp(dto);
     return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Dto> getEmp(@PathVariable("id") Long employeeid)
    {
        Dto getemp =service.getEmp(employeeid);
        return new ResponseEntity<>(getemp,HttpStatus.OK);
    }

    //get all Employee

    @GetMapping
    public ResponseEntity<List<Dto>> getall()
    {
           List<Dto> allemp=service.getallemp();
           return new ResponseEntity<>(allemp,HttpStatus.OK);
    }

    //Delete employee

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id)
    {
        service.delete(id);
        return  ResponseEntity.ok("Deleted Successfully");
    }

    // updated employee

    @PutMapping("{id}")
    public ResponseEntity<Dto> update(@PathVariable("id") Long id,@RequestBody Dto dto)
    {
        Dto updateEmp= service.update(id,dto);

        return new ResponseEntity<>(updateEmp,HttpStatus.OK);
    }
}
