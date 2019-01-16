package com.gvkhacha;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.gvkhacha.tetris.Tetris;

/**
  * 
  *
  */
public class TetrisGUI extends Pane{
    private final GameCanvas canvas;
    private Tetris game;
    TetrisGUI(){
        super();
        game = new Tetris();

        canvas = new GameCanvas();
        getChildren().add(canvas);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        redraw();
    }

    private void redraw(){
      canvas.clear();
      canvas.addRect(new Rectangle(0.20, 0.20, 0.5, 0.5), Color.CYAN);
    }

}