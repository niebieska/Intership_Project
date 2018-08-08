package com.softsystem.clinic.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softsystem.clinic.project.dao.ScheduleRepository;
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

}
