package com.vedruna.jugadoresequipos.services;

import java.util.List;


public interface TeamServiceI {
	
	List<TeamDTO> getAllTeams();
	TeamDTO getTeamByName (String name);
	TeamDTO getTeamById(int idTeam);
	void addTeam(TeamDTO team);
	void deleteTeam(TeamDTO teamDTO);

}