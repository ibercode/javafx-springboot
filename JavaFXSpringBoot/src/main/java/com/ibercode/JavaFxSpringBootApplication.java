package com.ibercode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class JavaFxSpringBootApplication extends Application{

	private ConfigurableApplicationContext springContext;
	private Parent rootNode;

	@Override
	public void init() throws Exception {
		
		springContext = SpringApplication.run(JavaFxSpringBootApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ibercode/controllers/Main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setScene(new Scene(rootNode));
		primaryStage.setTitle("IBERCODE");
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
