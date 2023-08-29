package br.sc.senac.dw.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.model.entidade.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{
	
	List<Fabricante> findAll(Specification<Fabricante> specification);
}
