package br.uece.eesdevop.filmesapi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Avaliacao {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long    id;
	private String  nome;
	private String  comentario;
	private Double  notaAvaliacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILME_ID")
	@JsonIgnore
	private Filme filme;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}
	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
}
