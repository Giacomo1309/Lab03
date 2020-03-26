/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.*;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.fxml.*;

public class FXMLController {

private Dictionary dictionary ;
private ObservableList<String> list = FXCollections.observableArrayList() ;

	    @FXML
	    private ComboBox<?> btnTendina;

	    @FXML
	    private TextArea txtInserisci;

	    @FXML
	    private Button btnSpell;

	    @FXML
	    private TextArea txtParoleErrate;

	    @FXML
	    private Button bntClear;

	    @FXML
	    private Label txtNumeroErrori;

	    @FXML
	    void doClear(ActionEvent event) {
	    	txtInserisci.clear();
	    	txtParoleErrate.clear();
	    	
	    }

	    @FXML
	    void doSpell(ActionEvent event) {
	    String inserite = txtInserisci.getText();
	    String[] listaInserite = inserite.split(" ");
	    List <String> listaInput = new LinkedList<String>();
	    for (String s : listaInserite) {
	    	listaInput.add(s);
	    }
	    dictionary.loadDictionary("italiano");
	    List<String> risultato = new LinkedList<String> (dictionary.paroleErrate2(dictionary.paroleErrate(dictionary.spellCheckText(listaInput)))) ;
	 //   risultato=dictionary.paroleErrate2(dictionary.paroleErrate(dictionary.spellCheckText(listaInput)));
	    for(String s : risultato) {
	    	txtParoleErrate.appendText(s+ "\n");
	    }
	    int errori = risultato.size();
	    
	    txtNumeroErrori.setText("il numero e "+ errori);
	    	
	    }
	    
	
	
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	  assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnTendina != null : "fx:id=\"btnTendina\" was not injected: check your FXML file 'Scene.fxml'.";
          list.addAll("inglese","italiano");
    //   problema ad aggiungere il bottone fottuto 
          assert txtParoleErrate != null : "fx:id=\"txtParoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnSpell != null : "fx:id=\" btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtNumeroErrori != null : "fx:id=\"txtNumeroErrori\" was not injected: check your FXML file 'Scene.fxml'.";
          assert bntClear != null : "fx:id=\"bntClear\" was not injected: check your FXML file 'Scene.fxml'.";        
    }

	public void setModel(Dictionary dictionary) {
		this.dictionary=dictionary;
		
	}
}


