package com.cocin.demo.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


    public Department createDepartment(DepartmentRequest departmentRequest) {
        // Convert the DepartmentRequest to Department entity
        Department department = new Department();
        department.setName(departmentRequest.getName());
        department.setDescription(departmentRequest.getDescription());

        // Save the department entity in the repository
        return departmentRepository.save(department);
    }
}
