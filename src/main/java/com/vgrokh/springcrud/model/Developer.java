package com.vgrokh.springcrud.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="developers")
public class Developer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "developerspecialities",
            joinColumns = {@JoinColumn(name="developerid") },
            inverseJoinColumns = { @JoinColumn(name="specialityid")}
    )
    private List<Speciality> specialities;
    @ManyToMany
    @JoinTable(
            name = "teamsdevelopers",
            joinColumns = {@JoinColumn(name="developerid") },
            inverseJoinColumns = { @JoinColumn(name="teamid")}
    )
    private List<Team> team;
}

