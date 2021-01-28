package com.vgrokh.springcrud.repository;

import com.vgrokh.springcrud.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {}
