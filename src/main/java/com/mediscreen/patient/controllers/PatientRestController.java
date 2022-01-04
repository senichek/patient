package com.mediscreen.patient.controllers;

import java.time.LocalDate;
import java.util.List;

import com.mediscreen.patient.models.Patient;
import com.mediscreen.patient.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @PostMapping(value = "/patient/add")
    public ResponseEntity<Patient> create(
        @RequestParam(name = "family") String lName,
        @RequestParam(name = "given") String fName,
        @RequestParam(name = "dob") String dateOfBirth,
        @RequestParam(name = "sex") String sex,
        @RequestParam(name = "address", required = false) String address,
        @RequestParam(name = "phone", required = false) String phone) throws Exception {
            Patient patient = new Patient();
            patient.setLastName(lName);
            patient.setFirstName(fName);
            patient.setBirthdate(LocalDate.parse(dateOfBirth));
            patient.setSex(sex);
            patient.setAddress(address);
            patient.setPhone(phone);
        return new ResponseEntity<>(patientService.create(patient), HttpStatus.OK);
    }

    @GetMapping(value = "/patient/all")
    public ResponseEntity<List<Patient>> getAll() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/patient")
    public ResponseEntity<Patient> getPatientById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/patient/update")
    public ResponseEntity<Patient> update(@RequestBody Patient patient) throws Exception {
        return new ResponseEntity<>(patientService.update(patient), HttpStatus.OK);
    }

    @DeleteMapping(value = "/patient/delete")
    public ResponseEntity<Patient> delete(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<>(patientService.delete(id), HttpStatus.OK);
    }
}
