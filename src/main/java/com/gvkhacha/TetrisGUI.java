package com.gvkhacha;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import com.gvkhacha.tetris.Tetris;
import com.gvkhacha.tetris.Block;

/**
  *
  *
  */
public class TetrisGUI extends GameGUI {
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
    TetrisGUI() {
        super();
        game = new Tetris();
        redraw();

        Timeline gameTick = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.update();
                redraw();
            }
        }));
        gameTick.setCycleCount(Timeline.INDEFINITE);
        gameTick.play();

    }


    public void handle(KeyEvent ke) {
        if(ke.getCode() == KeyCode.A)
            game.moveLeft();
        else if (ke.getCode() == KeyCode.D)
            game.moveRight();
        else if (ke.getCode() == KeyCode.W)
            game.rotateRight();
        else if (ke.getCode() == KeyCode.S)
            game.rotateLeft();
        redraw();
    }

    void redraw() {
        redraw_decorations();
        redraw_board();
        super.redraw();
    }

    private void redraw_decorations() {
        super.addToCanvas(board, board_fill);
    }

    private void redraw_board() {
        for(int r = 0; r < Tetris.NUM_ROWS; r++) {
            for(int c = 0; c < Tetris.NUM_COLUMNS; c++) {
                Block tile = game.tileAt(r, c);
                Color color;
                switch(tile) {
                case EMPTY:
                    if((r + c) % 2 == 0)
                        color = Color.rgb(160, 160, 160);
                    else
                        color = Color.rgb(150, 150, 150);
                    break;
                case CYAN:
                    color = Color.CYAN;
                    break;
                case YELLOW:
                    color = Color.YELLOW;
                    break;
                case PURPLE:
                    color = Color.PURPLE;
                    break;
                case BLUE:
                    color = Color.BLUE;
                    break;
                case ORANGE:
                    color = Color.ORANGE;
                    break;
                case GREEN:
                    color = Color.GREEN;
                    break;
                default:
                    color = Color.RED;
                }
                Rectangle rect = new Rectangle(BOARD_MARGIN_X + (DX * c), BOARD_MARGIN_Y + (DY * r), DX, DY);
                super.addToCanvas(rect, color);
            }
        }
    }
}