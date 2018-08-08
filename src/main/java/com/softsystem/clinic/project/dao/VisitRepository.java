package com.softsystem.clinic.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

}
