package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

	List<Movimiento> findByCuentaOrderByFechaDesc(Long cuenta);

}
