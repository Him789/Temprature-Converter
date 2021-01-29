package com.internshala.javafxapp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public  ChoiceBox<String>choiceBox;

	@FXML
	public TextField userF;

	@FXML
	public Button convertButton;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT ="Fahrenheit to Celsius";

	private boolean isC_TO_F = true;

	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{

			if(newValue.equals(C_TO_F_TEXT)){
				isC_TO_F = true;
			}
			else{
				isC_TO_F = false;
			}
		});

		convertButton.setOnAction(event -> { convert();
		});
	}

	private void convert() {

		String input = userF.getText();

		float enterTemp = 0.0f;
		try {
			 enterTemp = Float.parseFloat(input);
		}catch (Exception ex){
			wrong();
			return;
		}

		float newTemprature = 0.0f;
		if(isC_TO_F){
			newTemprature = (enterTemp * 9/5)+32;
		}
		else{
			newTemprature = (enterTemp - 32) *5/9;
		}

		display(newTemprature);
	}

	private void wrong() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Invalid Temprature Entered");
		alert.setContentText("Please enter a valid temprature");
		alert.show();
	}


	private void display(float newTemprature) {
		String unit = isC_TO_F? "F" : "C";
		System.out.println("the new Temprature is: "+newTemprature + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temprature is : "+ newTemprature +unit);
		alert.show();
	}
}

