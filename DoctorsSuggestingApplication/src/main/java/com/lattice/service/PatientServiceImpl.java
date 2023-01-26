package com.lattice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.entities.Doctor;
import com.lattice.entities.Patient;
import com.lattice.entities.Result;
import com.lattice.entities.SymptomsAllowed;
import com.lattice.exceptions.PatientException;
import com.lattice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorService doctorService;

	//For adding a Patient
	@Override
	public Patient addPatient(Patient patient)throws PatientException {
		if (patient != null) {
			if(!checkSymptom(patient.getSymptom())) {
				throw new PatientException("Only following Symptom values are allowed : "+SymptomsAllowed.allowed());
			}
			
			Patient p = patientRepo.save(patient);
			return p;
		} else {
			throw new PatientException("given patient details are not valid");
		}
	}

	//For deleting a Patient
	@Override
	public Patient deletePatient(Integer id)throws PatientException {
		Optional<Patient> object = patientRepo.findById(id);
		if (object.isPresent()) {
			Patient p = object.get();
			patientRepo.delete(p);
			return p;
		} else {
			throw new PatientException("No patient present with id : " + id);
		}
	}

	//To suggest Doctor by Patient id	
	@Override
	public Result getDoctorsByPatientId(Integer id)throws PatientException {
			Optional<Patient> object = patientRepo.findById(id);
			if(object.isPresent()) {
				Patient patient = object.get();
				SymptomsAllowed symptomEnum = SymptomsAllowed.valueOf(patient.getSymptom().toUpperCase().replace(" ", "_"));
				
				Result doctors = doctorService.getdoctorsList(patient.getCity(),symptomEnum.getSpeciality() );
				return doctors;
			}
			else {
				throw new PatientException("No patient present with id : "+id);
			}
		
	}
	
	
	
	//Utility functions
	public boolean checkSymptom(String symptom) {
		for (SymptomsAllowed el : SymptomsAllowed.values()) {
			if (symptom.equalsIgnoreCase(el.getDisplayName())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	//	Additional Api functions
	@Override
	public Patient updatePatient(Patient patient)throws PatientException {
		Optional<Patient> object = patientRepo.findById(patient.getId());
		if (object.isPresent()) {
			if(!checkSymptom(patient.getSymptom())) {
				throw new PatientException("Only following Symptom values are allowed : "+SymptomsAllowed.allowed());
			}
			
			Patient p = object.get();
			patientRepo.save(patient);
			return p;
		} else {
			throw new PatientException("No patient present with given details");
		}
	}
	

}
