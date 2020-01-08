package persistence;

import java.util.ArrayList;
import java.util.List;

import model.CorsoDiLaurea;
import model.Dipartimento;
import model.Scuola;
import model.Studente;
import model.Utente;

public class TempDB {
	List<Scuola> scuole;
	List<Studente> studenti;
	List<Dipartimento> dipartimenti;
	
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
		s.setScuolaDiDiploma(s1);
		studenti.add(s);
		
		dipartimenti = new ArrayList<Dipartimento>();
		
		Dipartimento d1 = new Dipartimento();
		d1.setId("1");
		d1.setNome("Matematica e Informatica");
		
		CorsoDiLaurea m = new CorsoDiLaurea();
		m.setId("1");
		m.setNome("Matematica");
		m.setDipartimento(d1);
		
		CorsoDiLaurea i = new CorsoDiLaurea();
		i.setId("2");
		i.setNome("Informatica");
		i.setDipartimento(d1);
		
		List<CorsoDiLaurea> corsi = new ArrayList<CorsoDiLaurea>();
		corsi.add(m);
		corsi.add(i);
		
		d1.setCorsiDiLaurea(corsi);
		
		dipartimenti.add(d1);
		
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
	
	public List<Dipartimento> dammiDipartimenti() {		
		return dipartimenti;
	}

	public Dipartimento dammiDipartimento(String dipartimento) {
		for (Dipartimento dip : dipartimenti) {
			if (dip.getId().equals(dipartimento)) {
				return dip;
			}
		}
		return null;
	}

	public Studente dammiStudente(String matricola) {
		for (Studente stud : studenti) {
			if (stud.getMatricola().equals(matricola)) {
				return stud;
			}
		}
		return null;
	}
}
