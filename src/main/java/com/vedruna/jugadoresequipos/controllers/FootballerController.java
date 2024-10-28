package com.vedruna.jugadoresequipos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.jugadoresequipos.dto.FootballerDTO;
import com.vedruna.jugadoresequipos.dto.TeamDTO;
import com.vedruna.jugadoresequipos.services.FootballerServiceImpl;

@RestController
@RequestMapping("/api/v1/footballers")
public class FootballerController {
	
	@Autowired
	FootballerServiceImpl footballerService;
	
	
	@GetMapping()
	public List<FootballerDTO> getALllPlayers(){
		return footballerService.getAllFootballers();
	}

	@PostMapping("/addPlayer")
	public void addPlayer(@RequestBody FootballerDTO footballerDTO) {
		footballerService.addFootballer(footballerDTO);
	}
	
	@PutMapping("/updateFootballer/{idFootballer}")
	public void addPlayerAteam(@PathVariable int idFootballer, @RequestBody TeamDTO teamDTO) {
		FootballerDTO footballerDTO = footballerService.getFootballerByidjugador(idFootballer);
		footballerDTO.setNameTeam(teamDTO.getName());
		 footballerService.updateFootballer(footballerDTO);
		
	}
	
	@DeleteMapping("/deletePlayer/{idplayer}")
	public void deletePlayer(@PathVariable int idplayer) {
		FootballerDTO footballer = footballerService.getFootballerByidjugador(idplayer);
		footballerService.deleteFootballer(footballer);
	}
	
}