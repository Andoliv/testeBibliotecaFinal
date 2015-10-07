package br.com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "testedsl")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "idpessoa")
	private Long idpessoa;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datanascimento")
	private Date datanascimento;
	@Column(name = "cpf")
	private String cpf;
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nome, Date datanascimento, String cpf) {
		//super();
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
