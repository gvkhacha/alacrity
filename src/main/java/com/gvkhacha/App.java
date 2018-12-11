package com.gvkhacha;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
  * JavaFX Application starting point
  * @author Garik Khachatryan
  * @version 0.1
  */
public class App extends Application {
    public App(){
        System.out.println("Created");
    }

    public void start (Stage stage){
        Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
    public static void main (String[] args){
        launch(args);
        System.out.println( "Hello World!" );
    }
}
