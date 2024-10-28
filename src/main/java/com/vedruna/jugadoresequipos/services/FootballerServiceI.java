package com.vedruna.jugadoresequipos.services;

import java.util.List;

import com.vedruna.jugadoresequipos.dto.FootballerDTO;


public interface FootballerServiceI {
	
	List<FootballerDTO> getAllFootballers();
	void addFootballer(FootballerDTO footballer);
	FootballerDTO getFootballerByName(String name);
	void updateFootballer(FootballerDTO footballer);
	void deleteFootballer(FootballerDTO footballer);
	FootballerDTO getFootballerByidjugador(int idjugador);
	
}