package br.com.fiap.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_INSIGHTIA_TRANSACAO")
@SequenceGenerator(name="transacao", sequenceName = "SQ_INSIGHTIA_TRANSACAO", allocationSize = 1)
public class Transacao {

	
	@Id
	@Column(name="id_transacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao")
	private Integer codigo;
	
	@Column(name="ds_titulo", nullable = false, length = 20)
	private String titulo;
	
	@Column(name="ds_transacao", nullable = false, length = 100)
	private String transacao;
	
	
	@Column(name="dt_cadastro", nullable = false)
	private Date data;
	
	@Column(name="vl_valor", nullable = false, length = 9)
	private Integer valor;
	
	private Usuario usuario;
	
	
	//Construtor
	
	public Transacao(String titulo, String transacao, Date data, Integer valor, Usuario usuario) {
		this.titulo = titulo;
		this.transacao = transacao;
		this.data = data;
		this.valor = valor;
		}
	
	public Transacao () {};

	
	//Getters & Setters
	
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTransacao() {
		return transacao;
	}


	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

		
	
}
