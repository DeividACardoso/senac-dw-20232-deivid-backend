package br.sc.senac.dw.model.seletor;

import java.time.LocalDate;

public class ProdutoSeletor extends BaseSeletor {

    private String nome;
    private String fabricanteCnpj;
    private String fabricanteNome;
    private Double valorMinimo;
    private Double valorMaximo;
    private Double pesoMinimo;
    private Double pesoMaximo;
    private LocalDate dataCadastroInicial;
    private LocalDate dataCadastroFinal;

	public String getNome() {
		return nome;
	}

	public String getFabricanteNome() {
		return fabricanteNome;
	}

	public void setFabricanteNome(String fabricanteNome) {
		this.fabricanteNome = fabricanteNome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricanteCnpj() {
		return fabricanteCnpj;
	}

	public void setFabricanteCnpj(String fabricanteCnpj) {
		this.fabricanteCnpj = fabricanteCnpj;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Double getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(Double pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public LocalDate getDataCadastroInicial() {
		return dataCadastroInicial;
	}

	public void setDataCadastroInicial(LocalDate dataCadastroInicial) {
		this.dataCadastroInicial = dataCadastroInicial;
	}

	public LocalDate getDataCadastroFinal() {
		return dataCadastroFinal;
	}

	public void setDataCadastroFinal(LocalDate dataCadastroFinal) {
		this.dataCadastroFinal = dataCadastroFinal;
	}
}