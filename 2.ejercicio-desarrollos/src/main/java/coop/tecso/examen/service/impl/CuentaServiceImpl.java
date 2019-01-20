package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.CuentaDto;
import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Override
	public String almacenarCuenta(CuentaDto cuentaDto) {
		String mesaje = "La cuenta no se pudo almacenar!";
		try{
			BigDecimal formatNumber = new BigDecimal(cuentaDto.getSaldo());
			formatNumber = formatNumber.setScale(2, RoundingMode.HALF_UP);	
			cuentaDto.setSaldo(formatNumber.floatValue());
			if(validarSiElSaldoEsPositivo(cuentaDto.getSaldo())){
				Cuenta cuenta = cargarCuentaConDatos(cuentaDto);
				cuentaRepository.saveAndFlush(cuenta);
				mesaje = "Cuenta almacenada exitosamente!";				
			}
		}catch(Exception e){
			System.out.println("Excepcion almacenando Cuenta: "+e.getMessage());			
		}
		return mesaje;
	}
	
	private boolean validarSiElSaldoEsPositivo(Float saldo){
		return saldo>=0?true:false;
	}
	
	private Cuenta cargarCuentaConDatos(CuentaDto cuentaDto){
		Cuenta cuenta = new Cuenta();		
		cuenta.setMoneda(cuentaDto.getMoneda());
		cuenta.setSaldo(cuentaDto.getSaldo());
		cuenta.setTitular(cuentaDto.getTitular());
		cuenta.setVersionNumber(1);
		cuenta.setCreationTimestamp(new Date());
		cuenta.setModificationTimestamp(new Date());
		return cuenta;
	}

	@Override
	public List<CuentaDto> obtenerTodasLasCuentas() {
		List<Cuenta> listaDeCuentas = cuentaRepository.findAll();
		return cargarListaConCuentasDto(listaDeCuentas);
	}
	
	private List<CuentaDto> cargarListaConCuentasDto(List<Cuenta> listaDeCuentas){
		List<CuentaDto> listaDeCuentasDto = new ArrayList<>();
		for(Cuenta cuenta: listaDeCuentas){
			CuentaDto cuentaDto = cargarCuentaDtoConDatos(cuenta);			
			listaDeCuentasDto.add(cuentaDto);
		}
		return listaDeCuentasDto;
	}

	private CuentaDto cargarCuentaDtoConDatos(Cuenta cuenta) {
		CuentaDto cuentaDto = new CuentaDto();
		cuentaDto.setId(cuenta.getId());
		cuentaDto.setMoneda(cuenta.getMoneda());
		cuentaDto.setSaldo(cuenta.getSaldo());
		cuentaDto.setTitular(cuenta.getTitular());
		cuentaDto.setVersion(cuenta.getVersionNumber());
		return cuentaDto;
	}

	@Override
	public String eliminarCuentaPorId(Long id) {
		String mesaje = "La cuenta no se pudo eliminar!";
		try{
			List<Movimiento> listaMovimientos = movimientoRepository.findByCuentaOrderByFechaDesc(id);
			if( listaMovimientos==null || listaMovimientos.isEmpty() ){
				cuentaRepository.deleteById(id);
				mesaje = "La cuenta se elimino exitosamente!";
			}else{
				mesaje = "La cuenta no se puede eliminar por que tiene movimientos asociados!";
			}
		}catch(Exception e){
			System.out.println("Excepcion eliminando Cuenta: "+e.getMessage());			
		}
		return mesaje;
	}

}
