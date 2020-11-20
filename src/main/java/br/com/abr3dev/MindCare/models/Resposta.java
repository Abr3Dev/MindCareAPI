package br.com.abr3dev.MindCare.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RESPOSTA")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_RESPOSTA")
	private Long id; 
	
	@Column(name="DS_TITULO", nullable = false)
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_CRIACAO", nullable = false)
	private Calendar dt_criacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_MODIFICACAO", nullable = false)
	private Calendar dt_modificacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_EXCLUSAO", nullable = false)
	private Calendar dt_exclusao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDt_criacao() {
		return dt_criacao;
	}

	public void setDt_criacao(Calendar dt_criacao) {
		this.dt_criacao = dt_criacao;
	}

	public Calendar getDt_modificacao() {
		return dt_modificacao;
	}

	public void setDt_modificacao(Calendar dt_modificacao) {
		this.dt_modificacao = dt_modificacao;
	}

	public Calendar getDt_exclusao() {
		return dt_exclusao;
	}

	public void setDt_exclusao(Calendar dt_exclusao) {
		this.dt_exclusao = dt_exclusao;
	}
}
