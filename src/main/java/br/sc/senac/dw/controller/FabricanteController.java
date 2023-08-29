package br.sc.senac.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.model.entidade.Fabricante;
import br.sc.senac.dw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.service.FabricanteService;

@RestController
@RequestMapping(path = "/api/fabricantes")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@PostMapping("/filtro")
	public List<Fabricante> listarComSeletor(@RequestBody FabricanteSeletor seletor){
		return fabricanteService.listarComSeletor(seletor);
		
	}
}
