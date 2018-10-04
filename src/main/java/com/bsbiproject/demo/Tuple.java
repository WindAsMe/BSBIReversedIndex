package com.bsbiproject.demo;

/**
 * Author     : WindAsMe
 * File       : Tuple.java
 * Time       : Create on 18-9-30
 * Location   : ../Home/BSBIProject/Tuple.java
 */
// imitate the Tuple in Python
public class Tuple {

    private int x;
    private int y;

    public Tuple() {
    }

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
