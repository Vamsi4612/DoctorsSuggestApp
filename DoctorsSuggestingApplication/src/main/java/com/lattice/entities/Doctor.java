package com.lattice.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	@Pattern(regexp="^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$", message = "Name should contain only letters")
	@Size(min=3, message = "Name should be of size minimum 3 charcters")
	private String name;
	
	@NotNull(message = "City cannot be null!")
	@NotBlank(message = "City connot be blank!")
	@Pattern(regexp="^[a-zA-Z0-9_]+([a-zA-Z0-9_]+)*$", message = "City should contain only letters")
	@Size(max=20, message = "City name should not be of more than 20 charcters")
	private String city;
	
	@Email
	private String email;
	
	@NotNull(message="Phone number cannot be null!")
	@NotBlank(message= "Phone number cannot be blank!")
	//@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit phone number")
	@Size(min = 10, max = 10, message = "Enter valid 10 digit phone number")
	private String phone_number;
	
	private String speciality;

	
	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Doctor(Integer id,
			@NotNull(message = "Name cannot be null!") @NotBlank(message = "Name connot be blank!") @Pattern(regexp = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$", message = "Name should contain only letters") @Size(min = 3, message = "Name should be of size minimum 3 charcters") String name,
			@NotNull(message = "City cannot be null!") @NotBlank(message = "City connot be blank!") @Pattern(regexp = "^[a-zA-Z0-9_]+([a-zA-Z0-9_]+)*$", message = "City should contain only letters") @Size(max = 20, message = "City name should not be of more than 20 charcters") String city,
			@Email String email,
			@NotNull(message = "Phone number cannot be null!") @NotBlank(message = "Phone number cannot be blank!") @Size(min = 10, max = 10, message = "Enter valid 10 digit phone number") String phone_number,
			String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phone_number = phone_number;
		this.speciality = speciality;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
