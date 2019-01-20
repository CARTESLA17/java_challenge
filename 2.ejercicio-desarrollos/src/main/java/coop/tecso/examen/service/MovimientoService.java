package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.dto.MovimientoDto;

public interface MovimientoService {

	String almacenarMovimiento(MovimientoDto movimientoDto);

	List<MovimientoDto> obtenerMovimientosPorCuenta(Long cuenta);

}
