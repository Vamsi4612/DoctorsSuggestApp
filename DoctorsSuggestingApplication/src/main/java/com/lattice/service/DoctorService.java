package com.lattice.service;

import com.lattice.entities.Doctor;
import com.lattice.entities.Result;
import com.lattice.exceptions.DoctorException;

public interface DoctorService {
	public Doctor addDoctor(Doctor doctor)throws DoctorException;
	public Doctor updateDoctor(Doctor task)throws DoctorException;
	public Doctor deleteDoctor(Integer id)throws DoctorException;
	
	public Result getdoctorsList(String city,String speciality);
	
}
