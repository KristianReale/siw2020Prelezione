package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Scuola;
import model.Studente;

public class TempDB {
	List<Scuola> scuole;
	List<Studente> studenti;
	
	public static TempDB instance = null;
	
	public static TempDB getInstance() {
		if (instance == null) {
			instance = new TempDB();
		}
		return instance;
	}
	
	private TempDB() {
		scuole = new ArrayList<Scuola>();
		
		Scuola s1 = new Scuola();
		s1.setId((long)1);
		s1.setCodiceMeccanografico("RC546545646");
		s1.setNome("Istituto Professionale");
		scuole.add(s1);
		
		studenti = new ArrayList<Studente>();
	}
	
	public List<Scuola> dammiScuole(){
		return scuole;
	}
	
	public void aggiungiStudente (Studente s) {
		studenti.add(s);
	}
	
	public Scuola dammiScuolaById(Long id){
		for (Scuola s : scuole) {
			if (s.getId() == id) {
				return s; 
			}
		}
		return null;
	}
}
