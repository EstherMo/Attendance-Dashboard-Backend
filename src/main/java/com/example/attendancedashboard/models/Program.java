package com.example.attendancedashboard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "PROGRAMS")
public class Program {

    //@JsonIgnoreProperties("programs") //solve JSON recursive dependency
    private Set<Participant> participants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Access(AccessType.PROPERTY)
    @ManyToMany(mappedBy = "programs")
    @ModelAttribute("getParticipants")
    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    @Column(name = "EVENT_NAME ")
    private String eventName;

    @Column(name = "PROGRAM_DATE")
    private Date programDate;

    @Column(name = "CATEGORY")
    private String category;



}