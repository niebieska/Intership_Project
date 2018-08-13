package com.softsystem.clinic.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

	@Query("select v from Visit v where v.vis_Reg_Date>CURRENT_DATE() and v.patientId=:patientId")
	public Reception findAllIncomingVisitsForSinglePatient(@Param("patientId")String patientId);
	
	@Query("select v from Visit v where v.vis_Reg_Date<CURRENT_DATE()")
	public List<Visit> findAllPerformedVisitsForAllPatients();
	
	@Query("select v from Visit v where v.patientId=:patientId")
	public Reception findAllVisitsForSinglePatient(@Param("patientId")String patientId);
	
	@Query("select v from Visit v where v.patientId=:patientId")
	public List<Visit> findAllVisitsForSinglePatient2(@Param("patientId")int patientId);
	
	@Query("select v from Visit v where v.vis_Reg_Date<CURRENT_DATE() and v.patientId=:patientId")
	public Reception findAllPerformedVisitsForSinglePatient(@Param("patientId")String patientId);
}
