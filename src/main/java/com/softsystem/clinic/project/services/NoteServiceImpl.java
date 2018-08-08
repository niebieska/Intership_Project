package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softsystem.clinic.project.dao.NoteRepository;
import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Note;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.model.Visit;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepositiry;


	@Override
	public String add(String note_Doc_Id, Date note_Date, String note_Body, Patient patientId, Visit visitId,Schedule scheduleId) {
		Note note = new Note();
		note.setNote_Date(note_Date);
		note.setNote_Body(note_Body);
		note.setNote_Doc_Id(note_Doc_Id);
		note.setPatientId(patientId);
		note.setScheduleId(scheduleId);
		note.setVisitId(visitId);
		noteRepositiry.save(note);
		return "doctor added";
	}

	@Override
	public void deleteOneNote(int id) {
		noteRepositiry.deleteById(id);

	}

	@Override
	public List<Note> listOfNots() {
		return (List<Note>) noteRepositiry.findAll();
	}

}
