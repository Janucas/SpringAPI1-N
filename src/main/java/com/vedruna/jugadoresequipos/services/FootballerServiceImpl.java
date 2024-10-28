package com.vedruna.jugadoresequipos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.jugadoresequipos.dto.FootballerDTO;
import com.vedruna.jugadoresequipos.persistance.models.Footballer;
import com.vedruna.jugadoresequipos.persistance.models.Team;
import com.vedruna.jugadoresequipos.persistance.repository.FootballerRepository;
import com.vedruna.jugadoresequipos.persistance.repository.TeamRepository;

@Service
public class FootballerServiceImpl implements FootballerServiceI{
	
	@Autowired
	FootballerRepository footballerRepository;
	
	@Autowired
	TeamRepository teamRepository;

    //3. Consultar todos los jugadores (Debe verse solo el nombre del equipo, pero no el objeto equipo entero)
	@Override
	public List<FootballerDTO> getAllFootballers() {
		List<Footballer> listFootballers = footballerRepository.findAll();
		List<FootballerDTO> listFootballersDTO = new ArrayList<>();
		
		for(Footballer footballer : listFootballers) {
			listFootballersDTO.add(new FootballerDTO(footballer));
		}
		return listFootballersDTO;
	}

    //Añadir futbolista-4. Crear nuevo jugador
	@Override
	public void addFootballer(FootballerDTO footballerDTO) {
		Footballer newPlayer = new Footballer();
		
		newPlayer.setIdPlayer(footballerDTO.getIdPlayer());
		newPlayer.setName(footballerDTO.getName());
		newPlayer.setAge(footballerDTO.getAge());
		
		Team team = teamRepository.findByName(footballerDTO.getNameTeam());
		newPlayer.setTeam(team);
		
		footballerRepository.save(newPlayer);
			
	}

    //Borrar futbolista-8. Borrar jugador (No debe borrarse su equipo)
	@Override
	public void deleteFootballer(FootballerDTO footballer) {
		Footballer player = footballerRepository.findByidPlayer(footballer.getIdPlayer());
		footballerRepository.delete(player);
	}

	@Override
	public FootballerDTO getFootballerByName(String name) {
		Footballer player = footballerRepository.findByName(name);
		
		FootballerDTO playerDTO = new FootballerDTO(player);
		return playerDTO;
	}

	@Override
	public FootballerDTO getFootballerByidjugador(int idjugador) {
		FootballerDTO player = new FootballerDTO(footballerRepository.findByidPlayer(idjugador));
	
		return player;
	}

    //6. Inscribir a un jugador en un equipo
	@Override
	public void updateFootballer(FootballerDTO footballer) {
		Footballer player = footballerRepository.findByidPlayer(footballer.getIdPlayer());
		player.setName(footballer.getName());
	    player.setAge(footballer.getAge());
	    
	    Team team = teamRepository.findByName(footballer.getNameTeam());
	    
	    player.setTeam(team);
		footballerRepository.save(player);
		
	}
	
	
	

}
