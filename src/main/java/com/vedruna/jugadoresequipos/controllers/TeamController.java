package com.vedruna.jugadoresequipos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.jugadoresequipos.dto.TeamDTO;
import com.vedruna.jugadoresequipos.services.TeamServiceImpI;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
	
	@Autowired
	TeamServiceImpI teamService;
	
	@GetMapping()
	public List<TeamDTO> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@GetMapping("/getTeamByName/{name}")
	public com.vedruna.jugadoresequipos.services.TeamDTO getTeamByName(@PathVariable String name) {
		return teamService.getTeamByName(name);
	}
	
	@PostMapping("/addTeam")
	public void addTeam(@RequestBody TeamDTO teamDTO) {
		teamService.addTeam(teamDTO);
	}
	
	@DeleteMapping("deleteTeam/{idTeam}")
	public void deleteTeam(@PathVariable int idTeam) {
		com.vedruna.jugadoresequipos.services.TeamDTO teamDTO = teamService.getTeamById(idTeam);
		teamService.deleteTeam(teamDTO);
		
	}
	

}