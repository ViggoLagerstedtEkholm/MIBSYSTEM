package com.mibsystem.demo.Models;

public class Vector2D {
    private double X;
    private double Y;

    public Vector2D(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public Vector2D(){
        this.X = 0;
        this.Y = 0;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }
}