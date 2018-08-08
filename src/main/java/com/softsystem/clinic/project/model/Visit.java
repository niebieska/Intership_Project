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
@Table(name = "VISIT")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	@Column(name = "VIS_ID")
	private int id;

	@NonNull
	@Column(name = "VIS_PRESC")
	private String vis_Presc;

	@NonNull
	@Column(name = "VIS_DOC_ID")
	private String vis_Doc_Id;

	@NonNull
	@Column(name = "ViS_REG_DATE")
	private Date vis_Reg_Date;

	@NonNull
	@Column(name = "ViS_DIS_DATE")
	private Date vis_Dis_Date;

	@NotNull
	@Column(name = "ViS_ROOM")
	private int vis_Room;

	@NotNull
	@Column(name = "ViS_CONFIRMATION")
	private boolean vis_Confirmation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REC_ID")
	@NotNull
	private Reception receptionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAT_ID")
	@NotNull
	private Patient patientId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCH_ID")
	@NotNull
	private Schedule scheduleId;
	
	public Visit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVis_Presc() {
		return vis_Presc;
	}

	public void setVis_Presc(String vis_Presc) {
		this.vis_Presc = vis_Presc;
	}

	public String getVis_Doc_Id() {
		return vis_Doc_Id;
	}

	public void setVis_Doc_Id(String vis_Doc_Id) {
		this.vis_Doc_Id = vis_Doc_Id;
	}

	public Date getVis_Reg_Date() {
		return vis_Reg_Date;
	}

	public void setVis_Reg_Date(Date vis_Reg_Date) {
		this.vis_Reg_Date = vis_Reg_Date;
	}

	public Date getVis_Dis_Date() {
		return vis_Dis_Date;
	}

	public void setVis_Dis_Date(Date vis_Dis_Date) {
		this.vis_Dis_Date = vis_Dis_Date;
	}

	public int getVis_Room() {
		return vis_Room;
	}

	public void setVis_Room(int vis_Room) {
		this.vis_Room = vis_Room;
	}

	public boolean isVis_Confirmation() {
		return vis_Confirmation;
	}

	public void setVis_Confirmation(boolean vis_Confirmation) {
		this.vis_Confirmation = vis_Confirmation;
	}
	
	public Reception getReceptionId() {
		return receptionId;
	}

	public void setReceptionId(Reception receptionId) {
		this.receptionId = receptionId;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Schedule getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Schedule scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", vis_Presc=" + vis_Presc + ", vis_Doc_Id=" + vis_Doc_Id + ", vis_Reg_Date="
				+ vis_Reg_Date + ", vis_Dis_Date=" + vis_Dis_Date + ", vis_Room=" + vis_Room + ", vis_Confirmation="
				+ vis_Confirmation + "]";
	}

}
