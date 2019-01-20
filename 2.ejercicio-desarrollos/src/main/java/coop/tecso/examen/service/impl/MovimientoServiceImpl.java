package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.enums.MonedaEnum;
import coop.tecso.examen.enums.TipoMovimientoEnum;
import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public String almacenarMovimiento(MovimientoDto movimientoDto) {
		String mesaje = "El movimiento no se pudo realizar!";
		try{
			BigDecimal formatNumber = new BigDecimal(movimientoDto.getImporte());
			formatNumber = formatNumber.setScale(2, RoundingMode.HALF_UP);	
			movimientoDto.setImporte(formatNumber.floatValue());
			Optional<Cuenta> cuenta = cuentaRepository.findById(movimientoDto.getCuenta());
			if( movimientoDto.getTipoMovimiento()==TipoMovimientoEnum.CREDITO.getId()){	
				Float saldoFinal = calcularSaldoFinal(cuenta.get().getSaldo(), movimientoDto.getImporte(), "CREDITO");
				cuenta.get().setSaldo(saldoFinal);
				realizarMovimiento(movimientoDto,cuenta);				
				mesaje = "Movimiento CREDITO realizado exitosamente!";				
			}else if(movimientoDto.getTipoMovimiento()==TipoMovimientoEnum.DEBITO.getId()){
				Float saldoFinal = calcularSaldoFinal(cuenta.get().getSaldo(), movimientoDto.getImporte(), "DEBITO");
				cuenta.get().setSaldo(saldoFinal);
				if(validarDescubiertoDeacuerdoAMoneda(saldoFinal, cuenta.get().getMoneda())){
					realizarMovimiento(movimientoDto,cuenta);
					mesaje = "DEBITO realizado exitosamente!";	
				}else{
					mesaje = "El DEBITO no se pudo realizar por que genera un descubierto mayor al permitido!";
				}				
			}
		}catch(Exception e){
			System.out.println("Excepcion almacenando el movimiento: "+e.getMessage());			
		}
		return mesaje;
	}
	
	private Movimiento cargarMovimientoConDatos(MovimientoDto movimientoDto){
		Movimiento movimiento = new Movimiento();
		movimiento.setVersionNumber(1);
		movimiento.setCreationTimestamp(new Date());
	    movimiento.setCreationTimestamp(new Date());
	    movimiento.setDescripcion(movimientoDto.getDescripcion());
	    OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
	    movimiento.setFecha(Date.from(utc.toInstant()));
	    movimiento.setCuenta(movimientoDto.getCuenta());
	    movimiento.setImporte(movimientoDto.getImporte());
	    movimiento.setTipoMovimiento(movimientoDto.getTipoMovimiento());
		return movimiento;
	}
	
	private Float calcularSaldoFinal(Float saldoActual, Float importe, String operacion){
		Float saldoFinal = new Float(0);
		if( "CREDITO".equals(operacion) ){
			saldoFinal = saldoActual+importe;
		}else if("DEBITO".equals(operacion)){
			saldoFinal = saldoActual-importe;
		}else{
			saldoFinal = saldoActual;
		}
		BigDecimal formatNumber = new BigDecimal(saldoFinal);
		formatNumber = formatNumber.setScale(2, RoundingMode.HALF_UP);
		return formatNumber.floatValue();
	}
	
	private void realizarMovimiento(MovimientoDto movimientoDto,Optional<Cuenta> cuenta){		
		Movimiento movimiento = cargarMovimientoConDatos(movimientoDto);
		movimientoRepository.saveAndFlush(movimiento);		
		cuentaRepository.saveAndFlush(cuenta.get());
	}
	
	private boolean validarDescubiertoDeacuerdoAMoneda(Float saldoFinal,int moneda){
		boolean validacionExitosa=false;
		if(moneda==MonedaEnum.PESOS.getId() && (saldoFinal>=(-1000.00)) ){
			validacionExitosa=true;
		}else if(moneda==MonedaEnum.DOLARES.getId() && (saldoFinal>=(-300.00)) ){
			validacionExitosa=true;
		}else if(moneda==MonedaEnum.EUROS.getId() && (saldoFinal>=(-150.00)) ){
			validacionExitosa=true;
		}
		return validacionExitosa;
	}

	@Override
	public List<MovimientoDto> obtenerMovimientosPorCuenta(Long cuenta) {
		List<Movimiento> listaMovimientos = movimientoRepository.findByCuentaOrderByFechaDesc(cuenta);
		return cargarListaConMovimientosDto(listaMovimientos);
	}
	
	private List<MovimientoDto> cargarListaConMovimientosDto(List<Movimiento> listaMovimientos){
		List<MovimientoDto> listaMovimientosDto = new ArrayList<>();
		for(Movimiento movimiento: listaMovimientos){
			MovimientoDto movimientoDto = new MovimientoDto();
			movimientoDto.setId(movimiento.getId());
			movimientoDto.setCuenta(movimiento.getCuenta());
			movimientoDto.setDescripcion(movimiento.getDescripcion());
			movimientoDto.setFecha(movimiento.getFecha());
			movimientoDto.setImporte(movimiento.getImporte());
			movimientoDto.setTipoMovimiento(movimiento.getTipoMovimiento());
			listaMovimientosDto.add(movimientoDto);
		}
		return listaMovimientosDto;
	}

}
