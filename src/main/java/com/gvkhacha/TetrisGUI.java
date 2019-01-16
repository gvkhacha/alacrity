package com.gvkhacha;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.gvkhacha.tetris.Tetris;
import com.gvkhacha.tetris.Block;
import java.util.Random;

/**
  * 
  *
  */
public class TetrisGUI extends Pane{
    private final GameCanvas canvas;
    private Tetris game;
    private static final double BOARD_MARGIN_X = 0.15;
    private static final double BOARD_MARGIN_Y = 0.10;
    private static final double BOARD_X = 1 - (2 * BOARD_MARGIN_X);
    private static final double BOARD_Y = 1 - (2 * BOARD_MARGIN_Y);
    private static final double DX = BOARD_X / Tetris.NUM_COLUMNS;
    private static final double DY = BOARD_Y / Tetris.NUM_ROWS;
    private static final Color board_fill = Color.CYAN;
    private static final Rectangle board = new Rectangle(BOARD_MARGIN_X, BOARD_MARGIN_Y, 
                                              BOARD_X, BOARD_Y);
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
      redraw_decorations();
      redraw_board();

    }

    private void redraw_decorations(){
      canvas.addRect(board, board_fill);
    }

    private void redraw_board(){
      for(int r=0; r<Tetris.NUM_ROWS; r++){
        for(int c=0; c<Tetris.NUM_COLUMNS; c++){
          Block tile = game.tileAt(r, c);
          Color color;
          switch(tile){
            case EMPTY:
              if((r+c) % 2 == 0)
                color = Color.rgb(160, 160, 160);
              else
                color = Color.rgb(150, 150, 150);
              break;
            case CYAN:
              color = Color.CYAN;
              break;
            default:
              color = Color.RED;
          }
          Rectangle rect = new Rectangle(BOARD_MARGIN_X + (DX * c), BOARD_MARGIN_Y + (DY * r), DX, DY);
          canvas.addRect(rect, color);
        }
      }
    }

}