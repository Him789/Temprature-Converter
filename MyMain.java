package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String args[]){
       launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temprature Converter Tool");
		primaryStage.show();

	}

	private MenuBar createMenu(){

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event ->{
			System.out.println("new was clicked");
		});

		SeparatorMenuItem seperatemenuItem = new SeparatorMenuItem();
		MenuItem quitmenuItem = new MenuItem("Quit");

		quitmenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});
		fileMenu.getItems().addAll(newMenuItem , seperatemenuItem, quitmenuItem);


		Menu helpMenu = new Menu("Help");
		MenuItem aboutmenuItem = new MenuItem("About");

		aboutmenuItem.setOnAction(event ->  {
			aboutApp();
		});

		MenuItem moremenuItem  = new Menu("More");
		helpMenu.getItems().addAll(aboutmenuItem , moremenuItem);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu , helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first Destop App");
		alertDialog.setHeaderText("Leaning JavaFX");
		alertDialog.setContentText("I am begineer but soon I will be a pro");

		ButtonType yesBut = new ButtonType("Yes");
		ButtonType noBut = new ButtonType("No");

		alertDialog.getButtonTypes().addAll(yesBut, noBut);

		Optional<ButtonType> clickBtn = alertDialog.showAndWait();

		if (clickBtn.isPresent() && clickBtn.get() == yesBut){
			System.out.println("Yes button is clicked");
	}
		/*else{
		        System.out.println("No button was clicked);
		        }
		 */

			 if(clickBtn.isPresent() && clickBtn.get() == noBut){
				System.out.println("No button is clicked");
			}

		}


	@Override
	public void stop() throws Exception {
		System.out.println("Temprature converter tool was closed");
		super.stop();
	}
}
