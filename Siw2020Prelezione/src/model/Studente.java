package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Studente {
	private String matricola;
	private String nome;
	private String cognome;
	private String dataNascita;
	private Scuola scuolaDiDiploma;
	private CorsoDiLaurea corsoDiLaurea;

	public Studente(){}
	
	public Studente(String matricola,String nome,String cognome,String dataNascita){
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public int hashCode(){
		return this.matricola.hashCode();
	}

	public boolean equals(Object object) {
		Studente studente = (Studente)object;
		return (this.getMatricola() == studente.getMatricola());
	}
	
	public Scuola getScuolaDiDiploma() {
		return scuolaDiDiploma;
	}
	
	public void setScuolaDiDiploma(Scuola scuolaDiDiploma) {
		this.scuolaDiDiploma = scuolaDiDiploma;
	}
	
	public CorsoDiLaurea getCorsoDiLaurea() {
		return corsoDiLaurea;
	}
	
	public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}
}
