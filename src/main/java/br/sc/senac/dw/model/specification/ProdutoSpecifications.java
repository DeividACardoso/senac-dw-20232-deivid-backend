package br.sc.senac.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoSpecifications {
	
    public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
                		+ seletor.getNome().toLowerCase() + "%"));
            }
            
            if (seletor.getFabricanteCnpj() != null && !seletor.getFabricanteCnpj().trim().isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.join("fabricante").get("cnpj")), seletor.getFabricanteCnpj()));
            }
            
            
            if (seletor.getFabricanteNome() != null && !seletor.getFabricanteNome().trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.join("fabricante").get("nome")), "%" 
                		+ seletor.getFabricanteNome().toLowerCase() + "%"));
            }
            
            // Peso BETWEEN
            if(seletor.getPesoMinimo() != null && !seletor.getPesoMinimo().toString().trim().isEmpty() 
            		&& seletor.getPesoMaximo() != null && !seletor.getPesoMaximo().toString().trim().isEmpty()) {
            	predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), 
            			seletor.getPesoMaximo()));
            } else if(seletor.getPesoMinimo() != null && !seletor.getPesoMinimo().toString().trim().isEmpty()) { // Peso >= pesoMinimo
            	predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if(seletor.getPesoMaximo() != null && !seletor.getPesoMaximo().toString().trim().isEmpty()) { // Peso <= pesoMaximo
            	predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }
            // Valor Between
            if(seletor.getValorMinimo() != null && !seletor.getValorMinimo().toString().trim().isEmpty() 
            		&& seletor.getValorMaximo() != null && !seletor.getValorMaximo().toString().trim().isEmpty()) {
            	predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), seletor.getValorMaximo()));
            } else if(seletor.getValorMinimo() != null && !seletor.getValorMinimo().toString().trim().isEmpty()) { // Valor >= ValorMinimo
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if(seletor.getValorMaximo() != null && !seletor.getValorMaximo().toString().trim().isEmpty()) { // Valor <= ValorMaximo
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }
            // Data Between
            if(seletor.getDataCadastroInicial() != null && !seletor.getDataCadastroInicial().toString().trim().isEmpty()
            		&& seletor.getDataCadastroFinal() != null && !seletor.getDataCadastroFinal().toString().trim().isEmpty()) {
            	predicates.add(cb.between(root.get("dt_cadastro"), seletor.getDataCadastroInicial(), seletor.getDataCadastroFinal()));
            } else if(seletor.getDataCadastroInicial() != null && !seletor.getDataCadastroInicial().toString().trim().isEmpty()) { // Data >= Dt_Inicial
            	predicates.add(cb.greaterThanOrEqualTo(root.get("dt_cadastro"), seletor.getDataCadastroInicial()));
            } else if(seletor.getDataCadastroFinal() != null && !seletor.getDataCadastroFinal().toString().trim().isEmpty()) { // Data <= Dt_Final
            	predicates.add(cb.lessThanOrEqualTo(root.get("dt_cadastro"), seletor.getDataCadastroFinal()));
            }
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}