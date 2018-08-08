package com.softsystem.clinic.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}
