package br.sc.senac.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.model.entidade.Fornecedor;
import br.sc.senac.dw.model.seletor.FornecedorSeletor;
import jakarta.persistence.criteria.Predicate;

public class FornecedorSpecifications {

	public static Specification<Fornecedor> comFiltros(FornecedorSeletor seletor){
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
				predicates.add(cb.like(root.get("nome"), 
						"%" + seletor.getNome().toLowerCase() + "%"));
			}
			
			if(seletor.getCnpj() != null && !seletor.getCnpj().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cnpj"),
						"%" + seletor.getCnpj() + "%"));
			}
			
			if(seletor.getCidade() != null && !seletor.getCidade().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cidade"),
						"%" + seletor.getCidade().toLowerCase() + "%"));
			}
			
			if(seletor.getCep() != null && !seletor.getCep().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cep"),
						"%" + seletor.getCep() + "%"));
			}
			
			if(seletor.getUf() != null && !seletor.getUf().trim().isEmpty()) {
				predicates.add(cb.like(root.get("uf"),
						"%" + seletor.getUf().toLowerCase() + "%"));
			}
			
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
