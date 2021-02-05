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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "developerspecialities",
            joinColumns = {@JoinColumn(name="developerid") },
            inverseJoinColumns = { @JoinColumn(name="specialityid")}
    )
    private List<Speciality> specialities;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}

