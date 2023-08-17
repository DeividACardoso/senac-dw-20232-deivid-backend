package br.sc.senac.dw.model.entidade;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
public class Produto{
	
	@jakarta.persistence.Id
	private Integer id;
	private String nome;
	private String fabricante;
	private double valor;
	private double peso;
	private LocalDate dt_Cadastro;
	
	public Produto(String nome, String fabricante, double valor, double peso, LocalDate dt_Cadastro) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
		this.peso = peso;
		this.dt_Cadastro = dt_Cadastro;
	}
	
	public Produto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getDt_cadastro() {
		return dt_Cadastro;
	}

	public void setDt_cadastro(LocalDate dt_Cadastro) {
		this.dt_Cadastro = dt_Cadastro;
	}
	
	
}
