package com.vgrokh.springcrud.repository;

import com.vgrokh.springcrud.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {}
