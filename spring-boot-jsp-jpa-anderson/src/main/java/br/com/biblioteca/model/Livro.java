package br.com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "testedsl")
public class Livro {

	@Id
	@GeneratedValue
	@Column(name = "idlivro")
	private Long idlivro;
	@Column(name = "nome")
	private String nome;
	@Column(name = "escritor")
	private String escritor;
	@Column(name = "anoedicao")
	private int anoedicao;
	@Column(name = "classificacao")
	private int classificacao;

	public Livro() {
	}

	public Livro(String nome, String escritor, int anoedicao, int classificacao) {
		// super();
		this.nome = nome;
		this.escritor = escritor;
		this.anoedicao = anoedicao;
		this.classificacao = classificacao;
	}

	public Long getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(Long idlivro) {
		this.idlivro = idlivro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public int getAnoedicao() {
		return anoedicao;
	}

	public void setAnoedicao(int anoedicao) {
		this.anoedicao = anoedicao;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

}
