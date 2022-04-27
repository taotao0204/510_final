package com.taoliu.final510.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

	public static Stage stage; // set global stage object!!!

	@Override
	public void start(Stage primaryStage) {
	
		//primaryStage.hide();

		try {
			stage = primaryStage;

			URL url = new URL("file:" + getClass().getResource("").getPath() + "../views/LoginView.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(url);
			AnchorPane root =  fxmlLoader.load();
			//AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);

//			scene.getStylesheets().add("styles.css");

			URL cssURL = new URL("file:" + getClass().getResource("").getPath() + "../views/styles.css");
			scene.getStylesheets().add(cssURL.toExternalForm());
			stage.setTitle("Login View");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
