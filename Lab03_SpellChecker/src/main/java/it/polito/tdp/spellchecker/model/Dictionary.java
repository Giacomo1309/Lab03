package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;

public class Dictionary {
	private Set<RichWord> dizionario= new HashSet<RichWord>();
	private List<RichWord> daCercare;
	private List<RichWord> errate;
	private List<String> errate2;

	public Dictionary(Set<RichWord> dizionario) {
	
	}

	public Dictionary() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permette il caricamento del dizionario della lingua giusta
	 * 
	 * @param language
	 */
	public void loadDictionary(String language) {
		language = language.toLowerCase();
		if (language.compareTo("italiano") == 0) {
			try {
				FileReader fr = new FileReader("src/main/resources/"+ "Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					// aggiungo la parola alla struttura dati
					RichWord aggiungere = new RichWord(word,true);
					dizionario.add(aggiungere);
					
					
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Errore lettura file");
			}
		}
		if (language.compareTo("inglese") == 0) {

			try {
				FileReader fr = new FileReader("English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					// aggiungo la parola alla struttura dati
					RichWord aggiungere = new RichWord(word,true);
					dizionario.add(aggiungere);
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Errore lettura file");
			}

		} //else {
			//throw new InvalidParameterException("Devi inserire un vocabolario tra italiano e inglese");
	//	}
	}
	/** 
	 * controlla e definisce il boolean in base a se le parole sono scritte giuste
	 * @param inputTextList
	 * @return
	 */
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		daCercare = new LinkedList<RichWord>();
		//Potrei farlo in un altro medoto a parte cosi che rimanga per qualsiasi controllo ma non mi va
		for(String s : inputTextList) {
			s=s.replaceAll("[.,\\/#!$%\\^&\\-_'()\\[\\]\"]", "");
		}
		for(String s : inputTextList) {
			RichWord q = new RichWord(s,true);
			if(dizionario.contains(q)) {
				daCercare.add(q);
			}
			else {
				q.setCorretto(false);
				daCercare.add(q);
			}
		}
		
		
		return daCercare;
	}
/** 
 * ritorna una lista di parole scritte in maniera errata	
 * @param daCercare
 * @return
 */
public List<RichWord> paroleErrate(List<RichWord> daCercare){
		errate = new LinkedList<RichWord>();
		for(RichWord w : daCercare) {
			if(w.isCorretto()==false) {
			errate.add(w);
			}
		}
		return errate;
	}
	public List<String> paroleErrate2(List<RichWord> daCercare){
		errate2 = new LinkedList<String>();
		for(RichWord w : daCercare) {
			errate2.add(w.getParola());
			
		}
		return errate2;
	}
	public String toString() {
		return "Dictionary [Dizionario=" + dizionario + "]";
	}

}
