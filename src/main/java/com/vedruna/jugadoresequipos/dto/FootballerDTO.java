package com.vedruna.jugadoresequipos.dto;

import com.vedruna.jugadoresequipos.persistance.models.Footballer;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FootballerDTO {
	
	private int idPlayer;
	private String name;
	private int age;
	private String nameTeam;
	
	//Con el DTO solo muestro los campos que se me piden y que yo quiero
	public FootballerDTO(Footballer footballer) {
		this.idPlayer = footballer.getIdPlayer(); //Id del futbolista
		this.name = footballer.getName(); //Nombre del futbolista
		this.age = footballer.getAge(); //Edad del futbolista
		if(footballer.getTeam() == null || footballer.getTeam().getName() == null) {
			this.nameTeam = "Actualmente no tiene equipo";
		}else {
			this.nameTeam = footballer.getTeam().getName();
		}
	}
	
}
