package br.com.fiap.jpa.entity;

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
@Table(name = "TB_INSIGHTIA_INSIGHT")
@SequenceGenerator(name = "insight", sequenceName = "SQ_INSIGHTIA_INSIGHT", allocationSize = 1)
public class Insight {

	@Id
	@Column(name = "id_insight")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insight")
	private Integer codigo;

	@Column(name = "ds_conteudo", nullable = false, length = 2000)
	private String conteudo;

	@Column(name = "ft_image", nullable = true)
	private String foto;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_anuncio", nullable = false)
	private Anuncio anuncio;

	// Construtor

	public Insight(String conteudo, String foto, Anuncio anuncio) {
		super();
		this.conteudo = conteudo;
		this.foto = foto;
		this.anuncio = anuncio;
	}

	public Insight() {
	};

	// Getters & Setters

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
