package com.gvkhacha;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
  * 
  *
  */
public class TetrisGUI extends Pane{
    private final GameCanvas canvas;
    TetrisGUI(){
        super();
        canvas = new GameCanvas();
        getChildren().add(canvas);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.addRect(new Rectangle(0.20, 0.20, 0.5, 0.5), Color.BLUE);
    }
}