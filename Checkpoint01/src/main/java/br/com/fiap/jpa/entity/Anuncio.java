package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private TipoAnuncio tipo;

	@Column(name = "ds_descricao", nullable = false, length = 100)
	private String conteudo;

	private Usuario usuario;

	private List<Comando> listaComando;

	private List<Insight> listaInsight;

	// Construtor

	public Anuncio(TipoAnuncio tipo, String conteudo, Usuario usuario) {
		this.tipo = tipo;
		this.conteudo = conteudo;
	}

	public Anuncio() {
	};

	// Getters & Setters

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public TipoAnuncio getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnuncio tipo) {
		this.tipo = tipo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comando> getListaComando() {
		return listaComando;
	}

	public void setListaComando(List<Comando> listaComando) {
		this.listaComando = listaComando;
	}

	public List<Insight> getListaInsight() {
		return listaInsight;
	}

	public void setListaInsight(List<Insight> listaInsight) {
		this.listaInsight = listaInsight;
	}

}
