package com.softsystem.clinic.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {

}
