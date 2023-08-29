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

            if (seletor.getNome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
                		+ seletor.getNome().toLowerCase() + "%"));
            }
            
            if (seletor.getFabricante() != null) {
                predicates.add(cb.like(cb.lower(root.join("fabricante").get("nome")), "%" 
                		+ seletor.getFabricante().toLowerCase() + "%"));
            }
            
            // Peso BETWEEN
            if(seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
            	predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), 
            			seletor.getPesoMaximo()));
            } else if(seletor.getPesoMinimo() != null) { // Peso >= pesoMinimo
            	predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if(seletor.getPesoMaximo() != null) { // Peso <= pesoMaximo
            	predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }
            // Valor Between
            if(seletor.getValorMinimo() !=  null && seletor.getValorMaximo() != null) {
            	predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), seletor.getValorMaximo()));
            } else if(seletor.getValorMinimo() != null) { // Valor >= ValorMinimo
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if(seletor.getValorMaximo() != null) { // Valor <= ValorMaximo
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }
            // Data Between
            if(seletor.getDataCadastroInicial() != null && seletor.getDataCadastroFinal() != null) {
            	predicates.add(cb.between(root.get("dt_cadastro"), seletor.getDataCadastroInicial(), seletor.getDataCadastroFinal()));
            } else if(seletor.getDataCadastroInicial() != null) { // Data >= Dt_Inicial
            	predicates.add(cb.greaterThanOrEqualTo(root.get("dt_cadastro"), seletor.getDataCadastroInicial()));
            } else if(seletor.getDataCadastroFinal() != null) { // Data <= Dt_Final
            	predicates.add(cb.lessThanOrEqualTo(root.get("dt_cadastro"), seletor.getDataCadastroFinal()));
            }
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}