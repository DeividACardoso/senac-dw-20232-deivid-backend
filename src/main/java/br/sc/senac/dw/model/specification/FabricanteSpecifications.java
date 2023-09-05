package br.sc.senac.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.model.entidade.Fabricante;
import br.sc.senac.dw.model.seletor.FabricanteSeletor;
import jakarta.persistence.criteria.Predicate;

public class FabricanteSpecifications {
	
	public static Specification<Fabricante> comFiltros(FabricanteSeletor seletor){
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getNome() != null) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
						+ seletor.getNome().toLowerCase() + "%"));
			}
			
			if(seletor.getCnpj() != null) {
				predicates.add(cb.equal((root.get("cnpj")), seletor.getCnpj()));
			}
			
			if(seletor.getIdProdutos() != null) {
				predicates.add(cb.equal(root.join("produto").get("idproduto"), "%" + seletor.getIdProdutos() + "%"));
			}
			return  cb.and(predicates.toArray(new Predicate[0]));
			
		};
	}
}
