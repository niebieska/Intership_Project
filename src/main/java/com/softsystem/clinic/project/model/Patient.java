package com.softsystem.clinic.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name="PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
	@Column(name="PAT_ID")
	private int id;
	
	@NonNull
	@Column(name="PAT_MRN")
	private String pat_Mrn;
	
	@NonNull
	@Column(name="PAT_FNAME")
	private String pat_Fname;
	
	@NonNull
	@Column(name="PAT_MNAME")
	private String pat_Mname;
	
	@NonNull
	@Column(name="PAT_LNAME")
	private String pat_Lname;
	
	@NonNull
	@Column(name="PAT_DOB")
	private Date pat_Dob;
	
	@NonNull
	@Column(name="PAT_SEX")
	private String pat_Sex;
	
	@Column(name="PAT_CONFIRMATION")
	private boolean pat_Confirmation;
	
	@NonNull
	@Column(name="PAT_PASSHASH")
	private String pat_Passhash;
	
	@NonNull
	@Column(name="PAT_EMAIL")
	private String patEmail;
	
	@Column(name="PAT_PHONE")
	private int pat_Phone;

	public Patient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getPat_Dob() {
		return pat_Dob;
	}

	public void setPat_Dob(Date pat_Dob) {
		this.pat_Dob = pat_Dob;
	}

	public String getPat_Sex() {
		return pat_Sex;
	}

	public void setPat_Sex(String pat_Sex) {
		this.pat_Sex = pat_Sex;
	}

	public boolean isPat_Confirmation() {
		return pat_Confirmation;
	}

	public void setPat_Confirmation(boolean pat_Confirmation) {
		this.pat_Confirmation = pat_Confirmation;
	}

	public String getPat_Passhash() {
		return pat_Passhash;
	}

	public void setPat_Passhash(String pat_Passhash) {
		this.pat_Passhash = pat_Passhash;
	}

	
	public String getPatEmail() {
		return patEmail;
	}

	public void setPatEmail(String patEmail) {
		this.patEmail = patEmail;
	}

	public int getPat_Phone() {
		return pat_Phone;
	}

	public void setPat_Phone(int pat_Phone) {
		this.pat_Phone = pat_Phone;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", pat_Mrn=" + pat_Mrn + ", pat_Fname=" + pat_Fname + ", pat_Mname=" + pat_Mname
				+ ", pat_Lname=" + pat_Lname + ", pat_Dob=" + pat_Dob + ", pat_Sex=" + pat_Sex + ", pat_Confirmation="
				+ pat_Confirmation + ", pat_Passhash=" + pat_Passhash + ", pat_Email=" + patEmail + ", pat_Phone="
				+ pat_Phone + "]";
	}
	
	
}
