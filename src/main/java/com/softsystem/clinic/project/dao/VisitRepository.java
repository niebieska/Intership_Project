package com.softsystem.clinic.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Visit;
import com.softsystem.clinic.project.validator.ConfirmViewModel;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {
	
	

	@Query("select v from Visit v where v.vis_Reg_Date>CURRENT_DATE() and v.patientId=:patientId")
	public List<Visit> findAllIncomingVisitsForSinglePatient(@Param("patientId")Patient patientId);
	
	@Query("select v from Visit v where v.vis_Reg_Date<CURRENT_DATE()")
	public List<Visit> findAllPerformedVisitsForAllPatients();
	
	@Query("select v from Visit v where v.vis_Reg_Date>CURRENT_DATE()")
	public List<Visit> findAllIncomingVisitsForAllPatients();
	
	@Query("select v from Visit v where v.vis_Reg_Date>CURRENT_DATE() and v.id=:id")
	public Visit findSingleVisitById(@Param("id")int id);
	
	@Query("select v from Visit v where v.vis_Reg_Date>CURRENT_DATE() and v.id=:id")
	public List<Visit> findFewVisitsById(@Param("id")int id);
	
	@Query("select v from Visit v where v.patientId=:patientId")
	public List<Visit> findAllVisitsForSinglePatient(@Param("patientId")Patient patientId);
	
	
	@Query("select v from Visit v where v.vis_Reg_Date<CURRENT_DATE() and v.patientId= :patientId")
	public List<Visit> findAllPerformedVisitsForSinglePatient(@Param("patientId")Patient patientId);
	
	
	
	
}
