package com.softsystem.clinic.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softsystem.clinic.project.dao.ScheduleRepository;
import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.services.ScheduleService;
import com.softsystem.clinic.project.services.ScheduleServiceImpl;

@RestController
public class ScheduleController {
	

	@Autowired
	private ScheduleServiceImpl scheduleServ;
	@Autowired
	private ScheduleRepository scheduleRepo;
	
	@GetMapping(value = "/allschedule")
	public List<Schedule> getAllSchedule()
	{
		return scheduleServ.listOfSchedules();
	}
	
	@GetMapping(value = "/schedule/{id}")
	public List<Schedule> getAllSchedule(@PathVariable String id)
	{
		return scheduleServ.findOne(id);
	}
	
	@DeleteMapping(value="/deleteschedule/{id}")
	private void delete(@PathVariable int id) {
		scheduleRepo.deleteById(id);
	}

	
	@PutMapping("/updateschedule/{id}")
	public ResponseEntity<Object> updateSchedule(@RequestBody Schedule schedule, @PathVariable int id) {

		Optional<Schedule> scheduleOptional =scheduleRepo.findById(id);
		if (!scheduleOptional.isPresent()) 
			return ResponseEntity.notFound().build();

		schedule.setId(id);
		scheduleRepo.save(schedule);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="/saveschedule")
	public  void saveSchedule(@RequestBody Schedule schedule){
		scheduleRepo.save(schedule);
	}

}
