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
    private static final double BOARD_MARGIN_X = 0.15;
    private static final double BOARD_MARGIN_Y = 0.10;
    private static final Color board_fill = Color.CYAN;
    private static final Rectangle board = new Rectangle(BOARD_MARGIN_X, BOARD_MARGIN_Y, 
                                              1 - (2 * BOARD_MARGIN_X), 1 - (2 * BOARD_MARGIN_Y));
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
      canvas.addRect(board, board_fill);
    }

}