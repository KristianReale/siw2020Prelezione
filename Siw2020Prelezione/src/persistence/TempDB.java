package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Scuola;
import model.Studente;
import model.Utente;

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
		
		Studente s = new Studente();
		s.setMatricola("12345");
		s.setNome("Mario");
		s.setCognome("Bianchi");
		studenti.add(s);
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
	
	public Utente login(String username, String password) {
		//Verificare se l'utente esiste su db
		if (username.equals("kristian") && password.equals("kristian")) {
			Utente u = new Utente();
			u.setUsername(username);
			u.setPassword(password);
			return u;
		}else {
			return null;
		}
	}

	public List<Studente> dammiStudenti() {		
		return studenti;
	}
}
