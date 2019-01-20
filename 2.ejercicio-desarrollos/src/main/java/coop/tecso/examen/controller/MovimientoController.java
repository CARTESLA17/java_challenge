package coop.tecso.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.service.MovimientoService;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
	
	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping("/almacenarMovimiento")
	public String almacenarMovimiento(@RequestBody MovimientoDto movimientoDto) {
		return movimientoService.almacenarMovimiento(movimientoDto);
	}
	
	@PostMapping("/obtenerMovimientosPorCuenta")
	public List<MovimientoDto> obtenerMovimientosPorCuenta(@RequestBody MovimientoDto movimientoDto) {		
		return movimientoService.obtenerMovimientosPorCuenta(movimientoDto.getCuenta());
	}

}
