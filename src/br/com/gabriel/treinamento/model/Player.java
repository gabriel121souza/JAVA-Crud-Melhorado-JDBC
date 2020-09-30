package br.com.gabriel.treinamento.model;

public class Player {
	private int id;
	private String nome;
	private String nickJogo;
	private int  level;
	private String ello;
	private int idade;
	private boolean competitivo = false;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNickJogo() {
		return nickJogo;
	}
	public void setNickJogo(String nickJogo) {
		this.nickJogo = nickJogo;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getEllo() {
		return ello;
	}
	public void setEllo(String ello) {
		this.ello = ello;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isCompetitivo() {
		return competitivo;
	}
	public void setCompetitivo(boolean competitivo) {
		this.competitivo = competitivo;
	}
	
	
}
