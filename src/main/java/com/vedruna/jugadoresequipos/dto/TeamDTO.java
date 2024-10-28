package com.vedruna.jugadoresequipos.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedruna.jugadoresequipos.persistance.models.Footballer;
import com.vedruna.jugadoresequipos.persistance.models.Team;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeamDTO {
	
	private int idTeam;
	private String name;
	private List<FootballerDTO> footballersDto; 

	
	
	public TeamDTO(Team team) {
		this.idTeam = team.getIdTeam(); //ID del equipo
		this.name = team.getName(); //nombre del equipo
		this.footballersDto = new ArrayList<>(); //lista de jugadores del equipo
		
		for (Footballer player : team.getFootballers()) {
            this.footballersDto.add(new FootballerDTO(player));
        }
	}
	
	
	

}
