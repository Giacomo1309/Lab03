package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Test {
			
private void run() {
	
	
		Dictionary diz = new Dictionary (null);
		diz.loadDictionary("italiano");
	//	String s= new String(("alb$!$%y&bero"));
	//	System.out.println(s.replaceAll("[.,\\/#!$%\\^&\\-_'()\\[\\]\"]", ""));
	//	System.out.println(diz.toString());
		List <String> inputTextList = new LinkedList <String>();
		inputTextList.add("prova");
		inputTextList.add("sjisdajisda");
		inputTextList.add("albero");
		inputTextList.add("alb?!$$bero");
		System.out.println(diz.spellCheckText(inputTextList).toString()); 
		
		
	}
	
	
	public static void main(String[] args) {
		Test test = new Test ();
		test.run();

	}

	

}
