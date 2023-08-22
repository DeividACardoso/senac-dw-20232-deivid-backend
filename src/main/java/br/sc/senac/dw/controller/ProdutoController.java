package br.sc.senac.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.service.ProdutoService;

@RestController
@RequestMapping(path  = "/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(path = "/todos")
	public List<Produto> listarTodosProdutos(){
		return produtoService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Produto listarPorId(@PathVariable Integer id) {
		return produtoService.listarPorId(id.longValue());
	}

	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) throws CampoInvalidoException {
		return produtoService.salvar(novoProduto);
	};
	
	@PutMapping
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException{
		return produtoService.atualizar(produtoParaAtualizar) != null;
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return produtoService.excluir(id);
	}
}
