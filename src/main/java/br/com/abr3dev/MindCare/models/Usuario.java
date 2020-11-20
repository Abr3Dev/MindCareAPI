package br.com.abr3dev.MindCare.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private Long id; 
	
	@Column(name="DS_NOME", nullable = false)
	private String nome; 
	
	@Column(name="NM_IDADE", nullable = false)
	private int idade; 
	
	@Column(name="BL_STATUS", nullable = false)
	private byte[] status; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_CRIACAO", nullable = false)
	private Calendar dt_criacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_MODIFICACAO", nullable = false)
	private Calendar dt_modificação; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_EXCLUSAO", nullable = false)
	private Calendar dt_exclusao;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pergunta> pergunta;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Resposta> resposta;

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getStatus() {
		return status;
	}

	public void setStatus(byte[] status) {
		this.status = status;
	}

	public Calendar getDt_criacao() {
		return dt_criacao;
	}

	public void setDt_criacao(Calendar dt_criacao) {
		this.dt_criacao = dt_criacao;
	}

	public Calendar getDt_modificação() {
		return dt_modificação;
	}

	public void setDt_modificação(Calendar dt_modificação) {
		this.dt_modificação = dt_modificação;
	}

	public Calendar getDt_exclusao() {
		return dt_exclusao;
	}

	public void setDt_exclusao(Calendar dt_exclusao) {
		this.dt_exclusao = dt_exclusao;
	}

	public List<Pergunta> getPergunta() {
		return pergunta;
	}

	public void setPergunta(List<Pergunta> pergunta) {
		this.pergunta = pergunta;
	}

	public List<Resposta> getResposta() {
		return resposta;
	}

	public void setResposta(List<Resposta> resposta) {
		this.resposta = resposta;
	}
}
