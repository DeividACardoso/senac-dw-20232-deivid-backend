package br.sc.senac.dw.model.seletor;

import java.util.List;

import br.sc.senac.dw.model.entidade.Produto;

public class FabricanteSeletor extends BaseSeletor{
	
	private String nome;
	private String cnpj;
	private Integer idProdutos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Integer getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(Integer idProdutos) {
		this.idProdutos = idProdutos;
	}
	
	
}
