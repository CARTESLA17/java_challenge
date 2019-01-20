package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.dto.CuentaDto;

public interface CuentaService {

	String almacenarCuenta(CuentaDto cuentaDto);

	List<CuentaDto> obtenerTodasLasCuentas();

	String eliminarCuentaPorId(Long id);

}
