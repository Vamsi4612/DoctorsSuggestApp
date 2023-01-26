package com.lattice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.entities.Patient;
import com.lattice.entities.Result;
import com.lattice.exceptions.PatientException;
import com.lattice.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient) throws PatientException {
		
		return new ResponseEntity<Patient>(patientService.addPatient(patient),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/patient")
	public ResponseEntity<Result> suggestDoctors(@RequestParam Integer patientId ) throws PatientException{
		return new ResponseEntity<Result>(patientService.getDoctorsByPatientId(patientId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/patient")
	public ResponseEntity<Patient> deleteEmp(@RequestParam Integer patientId ) throws PatientException{
		
		return new ResponseEntity<Patient>(patientService.deletePatient(patientId),HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePro(@Valid @RequestBody Patient patient) throws PatientException {
		return new ResponseEntity<Patient>(patientService.updatePatient(patient),HttpStatus.ACCEPTED);

	}
	
}
