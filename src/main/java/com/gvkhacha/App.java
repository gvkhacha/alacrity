package com.gvkhacha;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
  * JavaFX Application starting point
  * @author Garik Khachatryan
  * @version 0.1
  */
public class App extends Application implements EventHandler {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;

    private TabPane mainTabs;
    public App(){
        System.out.println("Created");
    }

    public void start (Stage stage){
        Button gameBtn = new Button("Start");
        gameBtn.setOnAction(this);
        Group root = new Group(gameBtn);


        mainTabs = new TabPane();
        Tab main = new Tab();
        main.setText("Home");
        main.setContent(root);
        main.setClosable(false);
        mainTabs.getTabs().add(main);


        Scene scene = new Scene(mainTabs, 400, 300);


        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.show();
    }

    @Override
    public void handle(Event e){
        Tab gameTab = new Tab();
        gameTab.setText("Tetris");
        gameTab.setContent(new TetrisGUI());
        mainTabs.getTabs().add(gameTab);
    }
    public static void main (String[] args){
        launch(args);
    }
}
