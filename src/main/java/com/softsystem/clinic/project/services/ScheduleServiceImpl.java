package com.softsystem.clinic.project.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softsystem.clinic.project.dao.ScheduleRepository;
import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public String add(Date sch_Starthour, Date sch_Endhour, Doctor doctorCode) {
		Schedule schedule=new Schedule();
		schedule.setSch_Endhour(sch_Starthour);
		schedule.setSch_Starthour(sch_Endhour);
		schedule.setDoctorCode(doctorCode);
		scheduleRepository.save(schedule);
		
		return "schedule added";
	}
	
	@Override
	public void deleteOneSchedule(int id) {
		scheduleRepository.deleteById(id);
		
	}

	@Override
	public List<Schedule> listOfSchedules() {
		return (List<Schedule>) scheduleRepository.findAll();
	}

	
	@Override
	public List<Schedule> findOne(String code) {
		List<Schedule> list =  (List<Schedule>) scheduleRepository.findAll();
		
		List<Schedule> newList = new ArrayList<Schedule>();
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");

		Date now = new Date();
		System.out.println(now.toString());
		for( Schedule sh : list)
		{
			System.out.println(sh.getSch_Starthour().toString());
			if(sh.getDoctorCode().getId().equals(code) && (sh.getSch_Endhour().after(now)) ) 
				newList.add(sh);
		}
		return newList;
	}
}
