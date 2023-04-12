package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSIGHTIA_USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "SQ_INSIGHTIA_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Integer codigo;
	
	@Column(name="nm_usuario", nullable = false, length = 40)
	private String nome;
	
	@Column(name="ds_email", nullable = false, length = 50)
	private String email;
	
	@Column(name="ds_senha", nullable = false, length = 20)
	private String senha;
	
	@Column(name="nr_saldo", nullable = false, length = 9)
	private Integer saldo;
	
	private List<Anuncio> listaAnuncio;
	
	private List<Transacao> listaTransacao ;

	//Construtor
	
	public Usuario(String nome, String email, String senha, Integer saldo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	public Usuario() {};
	
	//Getters & Setters

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public List<Transacao> getListaTransacao() {
		return listaTransacao;
	}

	public void setListaTransacao(List<Transacao> listaTransacao) {
		this.listaTransacao = listaTransacao;
	}

	public List<Anuncio> getListaAnuncio() {
		return listaAnuncio;
	}

	public void setListaAnuncio(List<Anuncio> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}
	

}
