package com.softsystem.clinic.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public boolean countPatientMRN(String pat_Mrn) {
        String queryString = "SELECT count(o.pat_Mrn) FROM Patient o where LOWER(o.pat_Mrn) = :pat_Mrn";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("pat_Mrn", pat_Mrn.toLowerCase());

        return (query.getSingleResult() > 0);
    }
	
	public boolean countPatientEmail(String patEmail) {
        String queryString = "SELECT count(o.patEmail) FROM Patient o where LOWER(o.patEmail) = :patEmail";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("patEmail", patEmail.toLowerCase());

        return (query.getSingleResult() > 0);
    }

}
