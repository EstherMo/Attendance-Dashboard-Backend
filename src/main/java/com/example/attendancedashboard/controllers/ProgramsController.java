package com.example.attendancedashboard.controllers;

import com.example.attendancedashboard.models.Program;
import com.example.attendancedashboard.repositories.ProgramsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProgramsController {

    @Autowired
    private ProgramsRepository programsRepository;

    @GetMapping("/programs")
    public Iterable<Program> findAllUsers() {
        return programsRepository.findAll(

        );
    }
    @GetMapping("/programs/{programId}")
    public Optional<Program> findProgramById(@PathVariable Long programId) {
        return programsRepository.findById(programId);
    }
    @DeleteMapping ("/programs/{programId}")
    public HttpStatus deleteUserById(@PathVariable Long programId) {
        programsRepository.deleteById(programId);
        return HttpStatus.OK;
    }
    @PostMapping("/programs")
    public Program createNewUser(@RequestBody Program newUser) {
        return programsRepository.save(newUser);
    }
    @PatchMapping("/programs/{programId}")
    public Program updateProgramById(@PathVariable Long programId, @RequestBody Program userRequest) {

        Program programFromDb = programsRepository.findById(programId).get();

        programFromDb.setEventName(userRequest.getEventName());
        programFromDb.setProgramDate(userRequest.getProgramDate());
        programFromDb.setCategory(userRequest.getCategory());

        return programsRepository.save(programFromDb);
    }

}