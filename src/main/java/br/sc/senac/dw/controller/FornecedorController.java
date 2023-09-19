package br.sc.senac.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entidade.Fornecedor;
import br.sc.senac.dw.model.seletor.FornecedorSeletor;
import br.sc.senac.dw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.service.FornecedorService;

@RestController
@RequestMapping(path = "/api/fornecedor")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping(path = "/todos")
	public List<Fornecedor> listarTodos(){
		return fornecedorService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Fornecedor listarPorId(@PathVariable Integer id) {
		return fornecedorService.listarPorId(id);
	}

	@PostMapping("/filtro")
	public List<Fornecedor> listarComFiltros(@RequestBody FornecedorSeletor seletor){
		return fornecedorService.listarComFiltros(seletor);
	}

	@PostMapping
	public Fornecedor salvar(@RequestBody Fornecedor novoFornecedor) throws CampoInvalidoException{
		return fornecedorService.salvar(novoFornecedor);
	}
	
	@PutMapping
	public boolean atualizar(@RequestBody Fornecedor fornecedorParaAtualizar) {
		return fornecedorService.atualizar(fornecedorParaAtualizar) != null;
	}
	
	@DeleteMapping(path = "/deletar-por-id/{id}")
	public boolean deletarPorId(@PathVariable Integer id) {
	return fornecedorService.deletarPorId(id);	
	}
	
}
