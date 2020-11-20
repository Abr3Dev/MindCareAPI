package br.com.abr3dev.MindCare.dtos;

import java.util.Calendar;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {
	
	private Long id;
	
	@NotBlank(message="Nome deve ser informado.")
	private String nome;
	
	@NotBlank(message="Nome deve ser informado.")
	private int idade;
	
	@NotBlank(message="Status deve ser preenchido.")
	private byte[] status;
	
	private Calendar dt_criacao;
	
	private Calendar dt_modificação; 
	
	private Calendar dt_exclusao;

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
	
}
