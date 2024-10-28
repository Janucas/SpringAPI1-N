package com.vedruna.jugadoresequipos.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="jugadores")
public class Footballer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idjugador")
	private int idPlayer;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="edad")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "equipos_idequipo")
	private Team team;
	

}