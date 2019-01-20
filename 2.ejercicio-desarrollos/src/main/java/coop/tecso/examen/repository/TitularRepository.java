package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.Titular;

public interface TitularRepository extends JpaRepository<Titular, Long>{	
	
	Titular findByCuit(Long cuit);
	
}
