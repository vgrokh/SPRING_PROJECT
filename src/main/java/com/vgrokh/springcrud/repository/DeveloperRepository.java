package com.vgrokh.springcrud.repository;

import com.vgrokh.springcrud.model.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {}
