package coop.tecso.examen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.TitularRepository;
import coop.tecso.examen.service.TitularService;
import coop.tecso.examen.utils.Utils;

@Service
public class TitularServiceImpl implements TitularService {
	
	@Autowired
	private TitularRepository titularRepository;

	@Override
	public boolean almacenarTitular(TitularDto titularDto) {
		boolean almacenadoExitoso = false;
		try{
			if(validarDatosDelTitular(titularDto)){
				Titular titular = cargarTitularConDatos(titularDto);
				titularRepository.saveAndFlush(titular);
				almacenadoExitoso=true;				
			}
		}catch(Exception e){
			System.out.println("Excepcion en almacenando Titular: "+e.getMessage());
			almacenadoExitoso = false;
		}
		return almacenadoExitoso;
	}
	
	@Override
	public List<TitularDto> obtenerTodosLosTitulares(){
		List<Titular> listaTitulares = titularRepository.findAll();		
		return cargarListaConTitularesDto(listaTitulares);
	}
	
	private List<TitularDto> cargarListaConTitularesDto(List<Titular> listaTitulares){
		List<TitularDto> listaTitularesDto = new ArrayList<>();
		for(Titular titular: listaTitulares){
			TitularDto titularDto = cargarTitularDtoConDatos(titular);			
			listaTitularesDto.add(titularDto);
		}
		return listaTitularesDto;
	}
	
	private Titular cargarTitularConDatos(TitularDto titularDto){
		Titular titular = new Titular();
		titular.setTipoPersona(titularDto.getTipoPersona());
		titular.setNombre(titularDto.getNombre());
		titular.setApellido(titularDto.getApellido());
		titular.setDNI(titularDto.getDNI());
		titular.setRazonSocial(titularDto.getRazonSocial());
		titular.setYear(titularDto.getYear());
		titular.setCuit(titularDto.getCUIT());
		titular.setVersionNumber(1);
		titular.setCreationTimestamp(new Date());
		titular.setModificationTimestamp(new Date());
		return titular;
	}
	
	private boolean validarDatosDelTitular(TitularDto titularDto){
		boolean datosCorrectos=false;
		if( titularDto.getTipoPersona()!=null && titularDto.getTipoPersona()==1){
			if(Utils.validarLongitudDeDato(titularDto.getNombre(), 80)
					&& Utils.validarLongitudDeDato(titularDto.getApellido(), 250)
					&& titularDto.getDNI() != null && titularDto.getCUIT()!=null){
				titularDto.setRazonSocial(null);
				titularDto.setYear(null);
				datosCorrectos = true;
			}
		}else if (titularDto.getTipoPersona()!=null && titularDto.getTipoPersona()==2){
			if(Utils.validarLongitudDeDato(titularDto.getRazonSocial(),100)
					&& titularDto.getYear()!=null
					&& titularDto.getYear() > 1
					&& titularDto.getYear() < (new Date().getYear()+1900)
					&& titularDto.getCUIT()!=null){
				titularDto.setNombre(null);
				titularDto.setApellido(null);
				titularDto.setDNI(null);
				datosCorrectos = true;
			}
		}	
		return datosCorrectos;
	}

	@Override
	public TitularDto obtenerTitularPorCuit(Long cuit) {
		Titular titular = titularRepository.findByCuit(cuit);
		return cargarTitularDtoConDatos(titular);
	}
	
	private TitularDto cargarTitularDtoConDatos(Titular titular){
		TitularDto titularDto = new TitularDto();
		titularDto.setId(titular.getId());
		titularDto.setTipoPersona(titular.getTipoPersona());
		titularDto.setNombre(titular.getNombre());
		titularDto.setApellido(titular.getApellido());
		titularDto.setDNI(titular.getDNI());
		titularDto.setRazonSocial(titular.getRazonSocial());
		titularDto.setYear(titular.getYear());
		titularDto.setCUIT(titular.getCuit());
		titularDto.setVersion(titular.getVersionNumber());		
		return titularDto;
	}

	@Override
	public boolean deleteTitularPorId(Long id) {
		try{
			titularRepository.deleteById(id);
			return true;
		}catch(Exception e){
			System.out.println("Excepcion eliminando Titular: "+e.getMessage());
			return false;
		}		
	}

	@Override
	public boolean actualizarTitular(TitularDto titularDto) {
		boolean actualizadoExitoso = false;
		try{
			if(validarDatosDelTitular(titularDto)){
				Titular titular = new Titular();
				titular.setTipoPersona(titularDto.getTipoPersona());
				titular.setNombre(titularDto.getNombre());
				titular.setApellido(titularDto.getApellido());
				titular.setDNI(titularDto.getDNI());
				titular.setRazonSocial(titularDto.getRazonSocial());
				titular.setYear(titularDto.getYear());
				titular.setCuit(titularDto.getCUIT());			
				titular.setId(titularDto.getId());
				titular.setVersionNumber(titularDto.getVersion());
				titular.setModificationTimestamp(new Date());
				titularRepository.saveAndFlush(titular);
				actualizadoExitoso=true;				
			}
		}catch(Exception e){
			System.out.println("Excepcion actualizando Titular: "+e.getMessage());
			return actualizadoExitoso;
		}
		return actualizadoExitoso;
	}

}
