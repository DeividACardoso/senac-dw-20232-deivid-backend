package br.sc.senac.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entidade.Produto;
import br.sc.senac.dw.model.repository.ProdutoRepository;
import br.sc.senac.dw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.model.specification.ProdutoSpecifications;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto listarPorId(Long id) {
		return produtoRepository.findById(id.longValue()).get();
	}

	public Produto salvar(Produto novoProduto) {
		return produtoRepository.save(novoProduto);
	}

	public Object atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(produtoParaAtualizar);
		return produtoRepository.save(produtoParaAtualizar);
	}

	private void validarCamposObrigatorios(Produto produto) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(produto.getNome(), "nome");
		mensagemValidacao += validarCampoDouble(produto.getValor(), "valor");
		mensagemValidacao += validarCampoDouble(produto.getPeso(), "peso");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public boolean excluir(Integer id) {
		produtoRepository.deleteById(id.longValue());
		return true;
	}

	public List<Produto> listarComSeletor(ProdutoSeletor seletor) {
		//https://www.baeldung.com/spring-data-jpa-query-by-example
		Specification<Produto> specification = ProdutoSpecifications.comFiltros(seletor);
		return produtoRepository.findAll(specification);
	}
}


