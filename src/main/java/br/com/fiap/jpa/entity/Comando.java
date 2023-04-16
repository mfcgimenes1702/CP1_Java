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
@Table(name="TB_INSIGHTIA_COMANDO")
@SequenceGenerator(name="comando", sequenceName = "SQ_INSIGHTIA_COMANDO", allocationSize = 1)
public class Comando {
	
	@Id
	@Column(name="id_comando")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comando")
	private Integer codigo;
	
	@Column(name="ds_conteudo", nullable = false, length = 2000)
	private String conteudo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_anuncio", nullable = false)
	private Anuncio anuncio;
	
	
	//Construtor
	public Comando(String conteudo, Anuncio anuncio) {	
		this.conteudo = conteudo;
		this.anuncio = anuncio;
	}
	
	public Comando () {};

	//Getters & Setters
	
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


	public Anuncio getAnuncio() {
		return anuncio;
	}


	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
	
	
	
	
}
