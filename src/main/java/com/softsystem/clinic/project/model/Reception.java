package com.softsystem.clinic.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="RECEPTION")
public class Reception {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
	@Column(name="REC_ID")
	private int id;
	
	@NonNull
	@Column(name="REC_FNAME")
	private String rec_FName;
	
	@NonNull
	@Column(name="REC_LNAME")
	private String rec_LName;
	
	@NonNull
	@Column(name="REC_PHONEENUM")
	private int rec_PhoneEnum;
	
	public Reception() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRec_FName() {
		return rec_FName;
	}

	public void setRec_FName(String rec_FName) {
		this.rec_FName = rec_FName;
	}

	public String getRec_LName() {
		return rec_LName;
	}

	public void setRec_LName(String rec_LName) {
		this.rec_LName = rec_LName;
	}

	public int getRec_PhoneEnum() {
		return rec_PhoneEnum;
	}

	public void setRec_PhoneEnum(int rec_PhoneEnum) {
		this.rec_PhoneEnum = rec_PhoneEnum;
	}

	@Override
	public String toString() {
		return "Reception [id=" + id + ", rec_FName=" + rec_FName + ", rec_LName=" + rec_LName + ", rec_PhoneEnum="
				+ rec_PhoneEnum + "]";
	}
	

}
