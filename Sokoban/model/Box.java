package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {


    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int leftUpperConnerX = getX() - getWidth() / 2;
        int leftUpperConnerY = getY() - getHeight() / 2;
        graphics.drawRect(leftUpperConnerX, leftUpperConnerY, width, height);
        graphics.fillRect(leftUpperConnerX, leftUpperConnerY, getWidth(), getHeight());


    }

    //метод, отвечающий за движение
    @Override
    public void move(int x, int y) {
        this.setX(getX() + x);
        this.setY(getY() + y);
    }
}
