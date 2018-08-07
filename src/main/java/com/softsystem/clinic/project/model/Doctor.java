package com.softsystem.clinic.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="DOCTOR")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
	@Column(name="DOC_CODE")
	private String id;
	
	@NonNull
	@Column(name="DOC_SPEC")
	private String doc_Spec;

	public Doctor() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDoc_Spec() {
		return doc_Spec;
	}

	public void setDoc_Spec(String doc_Spec) {
		this.doc_Spec = doc_Spec;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doc_Spec=" + doc_Spec + "]";
	}

	
}
