package com.softsystem.clinic.project.validator;

import java.util.Date;

import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;



@SuppressWarnings({ "deprecation", "unused" })
public class RegistrationViewModel {
	
	@NotBlank(message = "{NotEmpty.message}")
    @Size(max = 23, message = "{Size.name}")
	private String pat_Mrn;
	
	@NotBlank(message = "{NotEmpty.message}")
	@Size(max = 32, message = "{Size.name}")
	private String pat_Fname;
	
	@Size(max = 32, message = "{Size.name}")
	private String pat_Mname;
	
	@NotBlank(message = "{NotEmpty.message}")
	@Size(max = 32, message = "{Size.name}")
	private String pat_Lname;
	
	@NotBlank(message = "{NotEmpty.message}")
	private String pat_Dob;

	@NotBlank(message = "{NotEmpty.message}")
	private String pat_Sex;
	
	@NotBlank(message = "{NotEmpty.message}")
	@Size(min = 8, message = "{Size.password}")
	private String pat_Passhash;
	
	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-+]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Email.invalidEmail}")
    @Size(max = 150, message = "{Size.email}")
	private String pat_Email;
	
	public String getPat_Mrn() {
		return pat_Mrn;
	}

	public void setPat_Mrn(String pat_Mrn) {
		this.pat_Mrn = pat_Mrn;
	}

	public String getPat_Fname() {
		return pat_Fname;
	}

	public void setPat_Fname(String pat_Fname) {
		this.pat_Fname = pat_Fname;
	}

	public String getPat_Mname() {
		return pat_Mname;
	}

	public void setPat_Mname(String pat_Mname) {
		this.pat_Mname = pat_Mname;
	}

	public String getPat_Lname() {
		return pat_Lname;
	}

	public void setPat_Lname(String pat_Lname) {
		this.pat_Lname = pat_Lname;
	}

	public String getPat_Sex() {
		return pat_Sex;
	}

	public void setPat_Sex(String pat_Sex) {
		this.pat_Sex = pat_Sex;
	}

	public String getPat_Passhash() {
		return pat_Passhash;
	}

	public void setPat_Passhash(String pat_Passhash) {
		this.pat_Passhash = pat_Passhash;
	}

	public String getPat_Email() {
		return pat_Email;
	}

	public void setPat_Email(String pat_Email) {
		this.pat_Email = pat_Email;
	}

	public String getPat_Dob() {
		return pat_Dob;
	}

	public void setPat_Dob(String pat_Dob) {
		this.pat_Dob = pat_Dob;
	}

	
	
}
