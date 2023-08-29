package br.sc.senac.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.model.entidade.Fabricante;
import br.sc.senac.dw.model.repository.FabricanteRepository;
import br.sc.senac.dw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.model.specification.FabricanteSpecifications;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;

	public List<Fabricante> listarComSeletor(FabricanteSeletor seletor) {
		Specification<Fabricante> specification = FabricanteSpecifications.comFiltros(seletor);
		return fabricanteRepository.findAll(specification);
	}

}
