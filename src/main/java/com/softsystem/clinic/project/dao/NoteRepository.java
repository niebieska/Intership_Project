package com.softsystem.clinic.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
