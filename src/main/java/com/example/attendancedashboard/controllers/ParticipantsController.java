package com.example.attendancedashboard.controllers;

import com.example.attendancedashboard.models.Participant;
import com.example.attendancedashboard.repositories.ParticipantssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantsController {
    @Autowired
    private ParticipantssRepository psRepository2;

    @GetMapping("/participants")
    public Iterable<Participant> findAllParticipants() {
        return psRepository2.findAll(

        );
    }
//    @GetMapping("/programs/{programId}")
//    public Optional<Program> findProgramById(@PathVariable Long programId) {
//        return programsRepository.findById(programId);
//    }
//    @DeleteMapping ("/programs/{programId}")
//    public HttpStatus deleteUserById(@PathVariable Long programId) {
//        programsRepository.deleteById(programId);
//        return HttpStatus.OK;
//    }
//    @PostMapping("/programs")
//    public Program createNewUser(@RequestBody Program newUser) {
//        return programsRepository.save(newUser);
//    }
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