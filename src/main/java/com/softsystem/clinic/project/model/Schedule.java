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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name="SCHEDULE")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
	@Column(name="SCH_ID")
	private int id;

	@NonNull
	@Column(name="SCH_STARTWORK")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sch_Starthour;
	
	@NonNull
	@Column(name="SCH_ENDWORK")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sch_Endhour;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_CODE")
	@NotNull
	private Doctor doctorCode;

	public Schedule() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSch_Starthour() {
		return sch_Starthour;
	}

	public void setSch_Starthour(Date sch_Starthour) {
		this.sch_Starthour = sch_Starthour;
	}

	public Date getSch_Endhour() {
		return sch_Endhour;
	}

	public void setSch_Endhour(Date sch_Endhour) {
		this.sch_Endhour = sch_Endhour;
	}

	public Doctor getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(Doctor doctorCode) {
		this.doctorCode = doctorCode;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", sch_Starthour=" + sch_Starthour + ", sch_Endhour=" + sch_Endhour
				+ ", doctorCode=" + doctorCode + "]";
	}	
	
}
