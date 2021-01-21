package com.example.Admissionservice;

import com.example.Admissionservice.Model.EmployeesList;
import com.example.Admissionservice.Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionsResource {

    @Autowired
    private RestTemplate restTemplate;

    List<Patient> patients= Arrays.asList(
            new Patient("P1", "Joseph", "Nigerian"),
            new Patient("P2", "Gabor", "Hungarian")
    );

    @RequestMapping("/patients")
    public List<Patient> getPatients() {
        return patients;
    }

    @RequestMapping("/patients/{Id}")
    public Patient getPatientById(@PathVariable("Id") String Id) {
        Patient p = patients.stream()
                .filter(patient -> Id.equals(patient.getId()))
                .findAny()
                .orElse(null);
        return p;
    }

    @RequestMapping("/employees")
    public EmployeesList getEmployees() {
        EmployeesList employees =
                restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
        return employees;
    }
}
