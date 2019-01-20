package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.dto.TitularDto;

public interface TitularService {
	
	public boolean almacenarTitular(TitularDto titularDto);
	
	public List<TitularDto> obtenerTodosLosTitulares();

	public TitularDto obtenerTitularPorCuit(Long cuit);

	public boolean deleteTitularPorId(Long id);

	public boolean actualizarTitular(TitularDto titularDto);

}