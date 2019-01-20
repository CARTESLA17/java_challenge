package coop.tecso.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.service.TitularService;

@RestController
@RequestMapping("/titular")
public class TitularController{
	
	@Autowired
	private TitularService titularService;
	
	@PostMapping("/almacenarTitular")
	public boolean almacenarTitular(@RequestBody TitularDto titularDto) {
		return titularService.almacenarTitular(titularDto);
	}
	
	@GetMapping("/obtenerTodosLosTitulares")
	public List<TitularDto> obtenerTodosLosTitulares() {		
		return titularService.obtenerTodosLosTitulares();
	}
	
	@PostMapping("/obtenerTitularPorCuit")
	public TitularDto obtenerTitularPorCuit(@RequestBody TitularDto titularDto) {		
		return titularService.obtenerTitularPorCuit(titularDto.getCUIT());
	}
	
	@PostMapping("/eliminarTitularPorId")
	public boolean deleteTitularPorId(@RequestBody TitularDto titularDto) {		
		return titularService.deleteTitularPorId(titularDto.getId());
	}
	
	@PostMapping("/actualizarTitular")
	public boolean actualizarTitular(@RequestBody TitularDto titularDto) {		
		return titularService.actualizarTitular(titularDto);
	}

}