package com.lattice.service;

import com.lattice.entities.Patient;
import com.lattice.entities.Result;
import com.lattice.exceptions.PatientException;

public interface PatientService {
	public Patient addPatient(Patient patient)throws PatientException;
	public Patient updatePatient(Patient patient)throws PatientException;
	public Patient deletePatient(Integer id)throws PatientException;
	
	public Result getDoctorsByPatientId(Integer id)throws PatientException;
	
}
