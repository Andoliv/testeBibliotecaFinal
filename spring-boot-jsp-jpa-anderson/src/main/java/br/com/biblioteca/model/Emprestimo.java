package br.com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue
	@Column(name = "idemprestimo")
	private Long idemprestimo;
	@Column(name = "dataemprestimo")
	private Date dataemprestimo;
	@Column(name = "datahoradevolucao")
	private Date datahoradevolucao;
	@Column(name = "idpessoa")
	private Long idpessoa;
	@Column(name = "idlivro")
	private Long idlivro;
	
	public Emprestimo(){
		
	}
	
	public Emprestimo(Date dataemprestimo, Long idpessoa, Long idlivro, Date datahoradevolucao) {
		//super();
		this.dataemprestimo = dataemprestimo;
		this.idpessoa = idpessoa;
		this.idlivro = idlivro;
		this.datahoradevolucao = datahoradevolucao;
	}

	public Long getIdemprestimo() {
		return idemprestimo;
	}

	public void setIdemprestimo(Long idemprestimo) {
		this.idemprestimo = idemprestimo;
	}

	public Date getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(Date dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Long getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(Long idlivro) {
		this.idlivro = idlivro;
	}

	public Date getDatahoradevolucao() {
		return datahoradevolucao;
	}

	public void setDatahoradevolucao(Date datahoradevolucao) {
		this.datahoradevolucao = datahoradevolucao;
	}

	
	
}
