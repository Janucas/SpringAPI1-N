package com.vedruna.jugadoresequipos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.jugadoresequipos.persistance.models.Footballer;
import com.vedruna.jugadoresequipos.persistance.models.Team;
import com.vedruna.jugadoresequipos.persistance.repository.FootballerRepository;
import com.vedruna.jugadoresequipos.persistance.repository.TeamRepository;

@Service
public class TeamServiceImpI implements TeamServiceI{
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	FootballerRepository footballerRepository;

    //1. Consultar todos los equipos (Deben verse sus jugadores)
	@Override
	public List getAllTeams() {
		List<Team> teamList = teamRepository.findAll(); 
        List<TeamDTO> teamListDTO = new ArrayList<>();
        
        for(Team team : teamList) {
        	teamListDTO.add(new TeamDTO());
        }
        
        return teamListDTO;
	}

    //2. Consultar un solo equipo (Deben verse sus jugadores)
	@Override
	public TeamDTO getTeamByName(String name) {
		return new TeamDTO();
	
	}
    
    //5. Crear nuevo equipo
	@Override
	public void addTeam(TeamDTO teamDTO) {
		Team newTeam = new Team();
		
		newTeam.setIdTeam(teamDTO.getIdTeam());
		newTeam.setName(teamDTO.getName());
		newTeam.setFootballers(null);
		
		teamRepository.save(newTeam);
		
	}

    //7. Borrar equipo (No deben borrarse sus jugadores)
	@Override
	public void deleteTeam(TeamDTO teamDTO) {
		Team team = teamRepository.findByName(teamDTO.getName());
		
		  List<Footballer> players = footballerRepository.findByTeam(team);
	        for (Footballer player : players) {
	            player.setTeam(null);  
	            footballerRepository.save(player); 
	        }
		teamRepository.delete(team);
		
	}

	@Override
	public TeamDTO getTeamById(int idTeam) {
		throw new UnsupportedOperationException("Unimplemented method 'getTeamById'");
	}

   

	
}