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
    private double oldWidth;
    private double oldHeight;
    GameCanvas(){
        contents = new ArrayList<Rectangle>();
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
        oldWidth = (double) App.WINDOW_WIDTH;
        oldHeight = (double) App.WINDOW_HEIGHT;
    }

    private void draw(){
        double width = getWidth();
        double height = getHeight();
        if(width == 0 || height == 0){
            return;
        }

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        for(int i=0; i<contents.size(); i++){
            Rectangle r = contents.get(i);
            gc.setFill(r.getFill());
            double xRatio = r.getX() / oldWidth;
            double yRatio = r.getY() / oldHeight;
            double wRatio = r.getWidth() / oldWidth;
            double hRatio = r.getHeight() / oldWidth;

            r.setX(xRatio * width);
            r.setY(yRatio * height);
            r.setWidth(wRatio * width);
            r.setHeight(hRatio * height);

            gc.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
        }

        oldWidth = width;
        oldHeight = height;
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
      * @param rect Rectangle to add with only x, y, width, height
      * @param fill Paint fill configuration to use when drawing.
      */
    void addRect(Rectangle rect, Paint fill){
        rect.setFill(fill);
        contents.add(rect);
    }
}