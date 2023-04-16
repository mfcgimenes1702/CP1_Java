package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSIGHTIA_ANUNCIO")
@SequenceGenerator(name = "anuncio", sequenceName = "SQ_INSIGHTIA_ANUNCIO", allocationSize = 1)
public class Anuncio {

	@Id
	@Column(name = "id_anuncio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anuncio")
	private Integer codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "sg_ativo", nullable = false)
	private Status status;

	@Column(name = "ds_descricao", nullable = false, length = 100)
	private String descricao;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.MERGE)
	private List<Comando> comandos;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.MERGE)
	private List<Insight> insights;

	// Construtor
	public Anuncio() {
		// TODO Auto-generated constructor stub
	}

	public Anuncio(Integer codigo, Status status, String descricao, Usuario usuario, List<Comando> comandos,
			List<Insight> insights) {
		super();
		this.codigo = codigo;
		this.status = status;
		this.descricao = descricao;
		this.usuario = usuario;
		this.comandos = comandos;
		this.insights = insights;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comando> getComandos() {
		return comandos;
	}

	public void setComandos(List<Comando> comandos) {
		this.comandos = comandos;
	}

	public List<Insight> getInsights() {
		return insights;
	}

	public void setInsights(List<Insight> insights) {
		this.insights = insights;
	}
}
