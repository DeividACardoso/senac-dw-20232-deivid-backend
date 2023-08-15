package br.sc.senac.dw.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.entidade.Produto;

@RestController
@RequestMapping(path  = "/api/produtos")
public class ProdutoController {
	
	@GetMapping
	public List<Produto> listarTodosProdutos(){
		
		Produto p1 = new Produto("Produto 1", "Fabricante", 10.0, 1, LocalDate.now());
		Produto p2 = new Produto("Produto 2", "Fabricante 2", 15.0, 2, LocalDate.now());
		Produto p3 = new Produto("Produto 3", "Fabricante 3", 20.0, 3, LocalDate.now());
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		return lista;
	}
	
}
