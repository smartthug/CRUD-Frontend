package CRUD.Backend.Mapper;

import CRUD.Backend.Entity.Emp;
import CRUD.Backend.EmployeeDto.Dto;

public class EmpMapper {

    // Convert Entity → DTO
    public static Dto mapToDto(Emp employee) {
        return new Dto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getGender()
        );
    }

    // Convert DTO → Entity
    public static Emp mapToEntity(Dto dto) {
        return new Emp(
                dto.getId(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getEmail(),
                dto.getGender()
        );
    }
}
