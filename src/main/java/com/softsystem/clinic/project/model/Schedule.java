package com.softsystem.clinic.project.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name="SCH_DAY")
	private Date sch_Day;
	
	@NonNull
	@Column(name="SCH_STARTHOUR")
	@Temporal(TemporalType.TIME)
	private Date sch_Starthour;
	
	@NonNull
	@Column(name="SCH_ENDHOUR")
	@Temporal(TemporalType.TIME)
	private Date sch_Endhour;

	public Schedule() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSch_Day() {
		return sch_Day;
	}

	public void setSch_Day(Date sch_Day) {
		this.sch_Day = sch_Day;
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

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", sch_Day=" + sch_Day + ", sch_Starthour=" + sch_Starthour + ", sch_Endhour="
				+ sch_Endhour + "]";
	}
	
	
}
