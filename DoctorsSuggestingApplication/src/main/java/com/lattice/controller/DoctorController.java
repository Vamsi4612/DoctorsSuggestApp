package com.lattice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.entities.Doctor;
import com.lattice.exceptions.DoctorException;
import com.lattice.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor) throws DoctorException {
		
		return new ResponseEntity<Doctor>(doctorService.addDoctor(doctor),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/doctor")
	public ResponseEntity<Doctor> deleteEmp(@RequestParam Integer DoctorId ) throws DoctorException{
		return new ResponseEntity<Doctor>(doctorService.deleteDoctor(DoctorId),HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/doctor")
	public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody Doctor doctor) throws DoctorException {
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor),HttpStatus.ACCEPTED);
	}
}
