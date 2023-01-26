package com.lattice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.entities.CitiesAllowed;
import com.lattice.entities.Doctor;
import com.lattice.entities.Result;
import com.lattice.entities.SpecialitiesAllowed;
import com.lattice.exceptions.DoctorException;
import com.lattice.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;
	
	
	//For adding a Doctor
	@Override
	public Doctor addDoctor(Doctor doctor)throws DoctorException {
		if (doctor != null) {
			if(!checkCity(doctor.getCity())) {
				throw new DoctorException("Only following City names are allowed : "+Arrays.toString(CitiesAllowed.values()));
			}
			
			if(!checkSpeciality(doctor.getSpeciality())) {
				throw new DoctorException("Only following specialities values are allowed : "+Arrays.toString(SpecialitiesAllowed.values()));
			}
			
			Doctor e = doctorRepo.save(doctor);
			return e;
		} else {
			throw new DoctorException("given Doctor details are not valid");
		}
	}
	
	
	//For deleting a Doctor
	@Override
	public Doctor deleteDoctor(Integer id)throws DoctorException {
		Optional<Doctor> object = doctorRepo.findById(id);
		if (object.isPresent()) {
			Doctor e = object.get();
			doctorRepo.delete(e);
			return e;
		} else {
			throw new DoctorException("No Doctor present with id : " + id);
		}
	}
	
	
	//	Utility functions
	@Override
	public Result getdoctorsList(String city, String speciality) {
		Result result = new Result();
		List<Doctor> doctors = doctorRepo.findByCity(city);
		if (doctors.size() > 0) {
			result = filterBySpeciality(doctors, speciality);
			return result;
		} else {
			//System.out.println("We are still waiting to expand to your location");
			result.setOutput("We are still waiting to expand to your location");
			return result;
		}

		
	}

	public Result filterBySpeciality(List<Doctor> doctors, String speciality) {
		Result result = new Result();
		List<Doctor> filtered = doctors.stream().filter(d -> d.getSpeciality().equalsIgnoreCase(speciality))
				.collect(Collectors.toList());
		if (filtered.size() == 0) {
			//System.out.println("There isn’t any doctor present at your location for your symptom");
			result.setOutput("There isn’t any doctor present at your location for your symptom");
			return result;
		}
		result.setOutput("Success");
		result.setDoctorsAvaliable(filtered);
		return result;
	}

	public boolean checkCity(String city) {
		for (CitiesAllowed el : CitiesAllowed.values()) {
			if (city.equalsIgnoreCase(el.name())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkSpeciality(String speciality) {
		for (SpecialitiesAllowed el : SpecialitiesAllowed.values()) {
			if (speciality.equalsIgnoreCase(el.name())) {
				return true;
			}
		}
		return false;
	}
	
	
	
//	Additional Api functions
	
	@Override
	public Doctor updateDoctor(Doctor doctor)throws DoctorException {
		Optional<Doctor> object = doctorRepo.findById(doctor.getId());
		if (object.isPresent()) {
			Doctor p = object.get();
			doctorRepo.save(doctor);
			return p;
		} else {
			throw new DoctorException("No doctor present with given details");
		}
	}
	
	
}
