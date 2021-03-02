package com.vgrokh.springcrud.controller;

import com.vgrokh.springcrud.model.Developer;
import com.vgrokh.springcrud.model.Team;
import com.vgrokh.springcrud.model.TeamStatus;
import com.vgrokh.springcrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping(path = "{id}")
    public @ResponseBody Optional<Team> getTeamById(@PathVariable long id){
        return teamRepository.findById(id);
    }

    @GetMapping
    public @ResponseBody Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @DeleteMapping(path= "/delete/{id}")
    public void deleteTeamById(@PathVariable long id){
        teamRepository.deleteById(id);
    }

    @PostMapping(path = "/add")
    public void addTeam(@RequestParam String teamName, @RequestParam String teamStatus){
        Team team = new Team();
        team.setName(teamName);
        team.setStatus(TeamStatus.valueOf(teamStatus));
        teamRepository.save(team);
    }

}
