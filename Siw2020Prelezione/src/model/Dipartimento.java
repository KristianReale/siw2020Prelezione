package model;

import java.util.List;

public class Dipartimento {
	String id;
	String nome;
	List<CorsoDiLaurea> corsiDiLaurea;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<CorsoDiLaurea> getCorsiDiLaurea() {
		return corsiDiLaurea;
	}
	public void setCorsiDiLaurea(List<CorsoDiLaurea> corsiDiLaurea) {
		this.corsiDiLaurea = corsiDiLaurea;
	}
	
	
}
