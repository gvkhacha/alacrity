package com.gvkhacha;

import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

abstract class GameGUI extends Pane implements EventHandler<KeyEvent> {
    private final GameCanvas canvas;
    GameGUI() {
        super();
        canvas = new GameCanvas();
        getChildren().add(canvas);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());
    }

    public void handle(KeyEvent e) {
        canvas.clear();
        redraw();
    }

    void addToCanvas(Rectangle rect, Color fill) {
        canvas.addRect(rect, fill);
    }

    void redraw() {
        canvas.draw();
    }
}