package com.lattice.entities;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Result {
	
	private String output;
	private List<Doctor> doctorsAvaliable;
	
	//getters and setters
	public String getOutput() {
		return output;
	}
	
	public void setOutput(String output) {
		this.output = output;
	}
	
	public List<Doctor> getDoctorsAvaliable() {
		return doctorsAvaliable;
	}
	
	public void setDoctorsAvaliable(List<Doctor> doctorsAvaliable) {
		this.doctorsAvaliable = doctorsAvaliable;
	}
	
	
	public Result(String output, List<Doctor> doctorsAvaliable) {
		super();
		this.output = output;
		this.doctorsAvaliable = doctorsAvaliable;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Result [output=" + output + ", doctorsAvaliable=" + doctorsAvaliable + "]";
	}
	
	
	
	
	
}
