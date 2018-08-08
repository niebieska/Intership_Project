package com.softsystem.clinic.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "NOTE")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	@Column(name = "NOTE_ID")
	private int id;

	@NonNull
	@Column(name = "NOTE_DOC_ID")
	private String note_Doc_Id;

	@NonNull
	@Column(name = "NOTE_DATE")
	private Date note_Date;

	@NonNull
	@Column(name = "NOTE_BODY")
	private String note_Body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAT_ID")
	@NotNull
	private Patient patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VIS_ID")
	@NotNull
	private Visit visitId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCH_ID")
	@NotNull
	private Schedule scheduleId;

	public Note() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote_Doc_Id() {
		return note_Doc_Id;
	}

	public void setNote_Doc_Id(String note_Doc_Id) {
		this.note_Doc_Id = note_Doc_Id;
	}

	public Date getNote_Date() {
		return note_Date;
	}

	public void setNote_Date(Date note_Date) {
		this.note_Date = note_Date;
	}

	public String getNote_Body() {
		return note_Body;
	}

	public void setNote_Body(String note_Body) {
		this.note_Body = note_Body;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Visit getVisitId() {
		return visitId;
	}

	public void setVisitId(Visit visitId) {
		this.visitId = visitId;
	}

	public Schedule getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Schedule scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	@Override
	public String toString() {
		return "Note [id=" + id + ", note_Doc_Id=" + note_Doc_Id + ", note_Date=" + note_Date + ", note_Body="
				+ note_Body + "]";
	}

}
