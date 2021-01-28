package com.vgrokh.springcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
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

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    //@Fetch(FetchMode.JOIN)
//    @JoinTable(
//            name = "developerteams",
//            joinColumns = {@JoinColumn(name="developerid") },
//            inverseJoinColumns = { @JoinColumn(name="teamid")}
//    )
//    private List<Speciality> specialities;
//    private Team team;
}

