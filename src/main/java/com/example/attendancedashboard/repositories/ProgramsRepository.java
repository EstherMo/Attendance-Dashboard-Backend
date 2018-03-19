package com.example.attendancedashboard.repositories;

import com.example.attendancedashboard.models.Program;
import org.springframework.data.repository.CrudRepository;

public interface ProgramsRepository extends CrudRepository<Program, Long> {

}