package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSIGHTIA_TRANSACAO")
@SequenceGenerator(name = "transacao", sequenceName = "SQ_INSIGHTIA_TRANSACAO", allocationSize = 1)
public class Transacao {

	@Id
	@Column(name = "id_transacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao")
	private Integer codigo;

	@Column(name = "ds_titulo", nullable = false, length = 20)
	private String titulo;

	@Column(name = "ds_transacao", nullable = true, length = 100)
	private String descricao;

	@Column(name = "dt_cadastro", nullable = false)
	private Calendar dataCadastro;

	@Column(name = "vl_valor", nullable = false, length = 9)
	private Double valor;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	// Construtor

	public Transacao(String titulo, String descricao, Calendar dataCadastro, Double valor, Usuario usuario) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.valor = valor;
	}

	public Transacao() {
	};

	// Getters & Setters

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
