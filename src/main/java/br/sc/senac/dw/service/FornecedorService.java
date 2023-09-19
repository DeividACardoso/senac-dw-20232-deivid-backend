package br.sc.senac.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entidade.Fornecedor;
import br.sc.senac.dw.model.repository.FornecedorRepository;
import br.sc.senac.dw.model.seletor.FornecedorSeletor;
import br.sc.senac.dw.model.specification.FornecedorSpecifications;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}

	public Fornecedor listarPorId(Integer id) {
		return fornecedorRepository.findById(id.longValue()).get();
	}

	public List<Fornecedor> listarComFiltros(FornecedorSeletor seletor) {
		Specification<Fornecedor> specification = FornecedorSpecifications.comFiltros(seletor);
		return fornecedorRepository.findAll(specification);
	}

	public Fornecedor salvar(Fornecedor novoFornecedor) {
		return fornecedorRepository.save(novoFornecedor);
	}

	public Object atualizar(Fornecedor fornecedorParaAtualizar) {
		validarCamposObrigatorios(fornecedorParaAtualizar);
		return fornecedorRepository.save(fornecedorParaAtualizar);
	}

	public boolean deletarPorId(Integer id) {
		fornecedorRepository.deleteById(id.longValue());
		return true;
	}
	
	private void validarCamposObrigatorios(Fornecedor fornecedor) {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(fornecedor.getNome(), "Nome");
		mensagemValidacao += validarCampoString(fornecedor.getCnpj(), "CNPJ");
		mensagemValidacao += validarCampoString(fornecedor.getCidade(), "Cidade");
		mensagemValidacao += validarCampoString(fornecedor.getCep(), "CEP");
		mensagemValidacao += validarCampoString(fornecedor.getUf(), "UF");
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe " + nomeCampo + "/n"; 
		}
		return "";
	}

}
