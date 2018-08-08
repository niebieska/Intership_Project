package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;
import com.softsystem.clinic.project.model.Note;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.model.Visit;

public interface NoteService {

	public String add(String note_Doc_Id, Date note_Date, String note_Body, Patient patientId, Visit visitId,Schedule scheduleId);

	public void deleteOneNote(int id); 
	
	public List<Note> listOfNots(); 
}
