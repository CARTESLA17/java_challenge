package coop.tecso.examen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.TipoPersonaDto;
import coop.tecso.examen.model.TipoPersona;
import coop.tecso.examen.repository.TipoPersonaRepository;
import coop.tecso.examen.service.TipoPersonaService;
import javassist.compiler.ast.Symbol;


@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {
	
	@Autowired
	private TipoPersonaRepository tipoPersonaRepository;

	@Override
	public List<TipoPersonaDto> obtenerTiposDePersona() {
		List<TipoPersona> listaTiposPersona = tipoPersonaRepository.findAll();		
		return cargarListaConTipoPersonasDto(listaTiposPersona);
	}
	
	private List<TipoPersonaDto> cargarListaConTipoPersonasDto(List<TipoPersona> listaTiposPersona){
		List<TipoPersonaDto> listaTiposPersonaDto = new ArrayList<>();
		for(TipoPersona tipoPersona: listaTiposPersona){
			TipoPersonaDto tipoPersonaDto = new TipoPersonaDto();
			tipoPersonaDto.setId(tipoPersona.getId());
			tipoPersonaDto.setDescripcion(tipoPersona.getDescripcion());
			listaTiposPersonaDto.add(tipoPersonaDto);
		}
		return listaTiposPersonaDto;
	}

}
