package com.example.attendancedashboard.controllers;

import com.example.attendancedashboard.models.Participant;
import com.example.attendancedashboard.repositories.ParticipantssRepository;
import com.example.attendancedashboard.repositories.ProgramsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ParticipantsController {
    @Autowired
    private ParticipantssRepository psRepository;

    @Autowired
    private ProgramsRepository programsRepository;

    @GetMapping("/participants")
    public Iterable<Participant> findAllParticipants() {
        return psRepository.findAll(

        );
    }

    //find all participants for a specific program
    @GetMapping("/participants/program/{programId}")
    public Iterable<Participant> findParticipantsbyProgramId(@PathVariable long programId) {
        return psRepository.findByProgramsId(programId);
    }

    @GetMapping("/participants/{participantId}")
    public Optional<Participant> findParticipantById(@PathVariable Long participantId) {
        return psRepository.findById(participantId);
    }
    @DeleteMapping("/participants/{participantId}")
    public HttpStatus deleteParticipantById(@PathVariable Long participantId) {
        psRepository.deleteById(participantId);
        return HttpStatus.OK;
    }
    @PostMapping("/participants")
    public Participant createNewParticipant(@RequestBody Participant newParticipant) {
        return psRepository.save(newParticipant);
    }
//    @PatchMapping("/programs/{programId}")
//    public Program updateProgramById(@PathVariable Long programId, @RequestBody Program userRequest) {
//
//        Program programFromDb = programsRepository.findById(programId).get();
//
//        programFromDb.setEventName(userRequest.getEventName());
//        programFromDb.setProgramDate(userRequest.getProgramDate());
//        programFromDb.setCategory(userRequest.getCategory());
//
//        return programsRepository.save(programFromDb);
//    }

}