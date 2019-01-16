package com.gvkhacha;
import java.util.ArrayList;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
  * Wrapper class for Canvas to have a
  * constantly resizing Canvas since most games will use that
  * Should be bound to parent width/height properties:
  * GameCanvas.widthProperty().bind(___.widthProperty());
  */
class GameCanvas extends Canvas{
    private ArrayList<Rectangle> contents;
    GameCanvas(){
        contents = new ArrayList<Rectangle>();
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    void draw(){
        double width = getWidth();
        double height = getHeight();
        if(width == 0 || height == 0){
            return;
        }

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        for(int i=0; i<contents.size(); i++){
            Rectangle r = contents.get(i);
            Color fill = (Color) r.getFill();
            gc.setFill(fill);
            gc.fillRect(r.getX() * width, r.getY() * height,
                 r.getWidth() * width, r.getHeight() * height);
        }
    }

    @Override
    public boolean isResizable(){
        return true;
    }

    @Override
    public double prefWidth(double height){
        return getWidth();
    }

    @Override
    public double prefHeight(double width){
        return getHeight();
    }

    /**
      * Adds a rectangle to the Canvas.
      * Rectangle is originally made in regards to the 
      * size of App.WINDOW_WIDTH and App.WINDOW_HEIGHT.
      * Can be scaled from there on.
      * @param rect Rectangle with x, y, width, and height being percentages.
      * @param fill Paint fill configuration to use when drawing.
      */
    void addRect(Rectangle rect, Paint fill){
        rect.setFill(fill);
        contents.add(rect);
    }

    void clear(){
      getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
    }
}