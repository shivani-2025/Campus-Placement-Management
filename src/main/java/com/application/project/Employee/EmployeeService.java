package com.application.project.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1) GET ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 2) GET BY ID
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // 3) ADD
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 4) UPDATE
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);

        existing.setName(updatedEmployee.getName());
        existing.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setGender(updatedEmployee.getGender());
        existing.setLevel(updatedEmployee.getLevel());

        // FOREIGN KEY 
        existing.setEmployeeStatus(updatedEmployee.getEmployeeStatus());

        existing.setBu(updatedEmployee.getBu());
        existing.setPannelistType(updatedEmployee.getPannelistType());

        return employeeRepository.save(existing);
    }

    // 5) DELETE
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
