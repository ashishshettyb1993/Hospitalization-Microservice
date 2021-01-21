package com.example.HRservice;

import com.example.HRservice.Model.Employee;
import com.example.HRservice.Model.EmployeesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrResource {

    List<Employee> employees = Arrays.asList(
            new Employee("E1", "Kindson", "Munonye", "MedTech"),
            new Employee("E2", "Kate", "Winters", "Surgery")
    );

    @RequestMapping("/employees")
    public EmployeesList getEmployees() {

        EmployeesList employeesList = new EmployeesList();
        employeesList.setEmployeeList(employees);
        return employeesList;
    }

    //getEmployeeById returns an employee with the given Id
    @RequestMapping("/employees/{Id}")
    public Employee getEmployeeById(@PathVariable("Id") String Id) {
        Employee e = employees.stream()
                .filter(employee ->Id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        return e;
    }
}
