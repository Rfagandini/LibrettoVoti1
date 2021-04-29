package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class FXMLController {

	private Libretto model;
	
	public void setModel(Libretto model) {
		this.model = model;
	}
	
	@FXML
	private void initialize(URL url, ResourceBundle rb) {
		
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea AreaofSubjects;

    @FXML
    private TextField SubjectElection;

    @FXML
    private TextField GradeElection;

    @FXML
    private DatePicker DataElection;
    
    @FXML
    private Label Message;

    @FXML
    void EnterButton(ActionEvent event) {
    	
    	String a = SubjectElection.getText();
    	
    	if(a.length()==0) {
    		Message.setText("Please Enter a Subject");
    		return;
    	}
    	
    	int b;
    	String y = GradeElection.getText();
    	if(y.length()==0) {
    		Message.setText("Please Enter a Grade");
    		return;
    	}
    	
    	try {
    		
    	b = Integer.parseInt(y);
    	
    	}
    	
    	catch(NumberFormatException e) {
    		Message.setText("Please Enter a Number");
    		return;
    	}
    	
    	LocalDate c = DataElection.getValue();
    	
    	if(c==null) {
    		
    		Message.setText("Please choose a Date");
    		return;
    		
    	}
    	
    	
    	model.AddVoto(a, b, c);
    	
    	if(model.IsRepeatedCourse() == true) {
    		Message.setText(model.RepeatedCourse());
    		return;
    	}
    	
    	
    	AreaofSubjects.setText(model.StringDiCorsiSuperati());
    	
    	Message.setText("");
    	SubjectElection.setText("");
    	GradeElection.setText("");
    	DataElection.setValue(null);
    	
    }

    @FXML
    void initialize() {
        assert AreaofSubjects != null : "fx:id=\"AreaofSubjects\" was not injected: check your FXML file 'Scene.fxml'.";
        assert SubjectElection != null : "fx:id=\"SubjectElection\" was not injected: check your FXML file 'Scene.fxml'.";
        assert GradeElection != null : "fx:id=\"GradeElection\" was not injected: check your FXML file 'Scene.fxml'.";
        assert DataElection != null : "fx:id=\"DataElection\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Message != null : "fx:id=\"Message\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}
