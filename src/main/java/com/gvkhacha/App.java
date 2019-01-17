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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.List;

/**
  * JavaFX Application starting point
  * @author Garik Khachatryan
  * @version 0.1
  */
public class App extends Application implements EventHandler {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;
    private Scene scene;
    private List<GameGUI> games;

    private TabPane mainTabs;
    public App() {
        System.out.println("Created");
    }

    public void start (Stage stage) {
        games = new ArrayList<GameGUI>();

        Button gameBtn = new Button("Start");
        gameBtn.setOnAction(this);
        Group root = new Group(gameBtn);


        mainTabs = new TabPane();
        Tab main = new Tab();
        main.setText("Home");
        main.setContent(root);
        main.setClosable(false);
        mainTabs.getTabs().add(main);


        scene = new Scene(mainTabs, 400, 300);


        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.show();

        mainTabs.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<Tab>() {
            // This should also pause/resume the games in other tabs. 
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                int index = mainTabs.getSelectionModel().getSelectedIndex();
                if(index != 0)
                    scene.setOnKeyPressed(games.get(index - 1));
            }
        }
        );
    }

    @Override
    public void handle(Event e) {
        Tab gameTab = new Tab();
        gameTab.setText("Tetris");
        TetrisGUI game = new TetrisGUI();
        games.add(game);
        gameTab.setContent(game);

        mainTabs.getTabs().add(gameTab);
    }
    public static void main (String[] args) {
        launch(args);
    }
}
