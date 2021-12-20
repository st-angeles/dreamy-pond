package com.adventofcode.y2021.d7;

public class Crab {
    private int horizontalPosition;

    public Crab(int horizPos){
        this.horizontalPosition = horizPos;
    }

    public int getRequiredFuel(int newHorizontalPosition){
        return Math.abs(horizontalPosition - newHorizontalPosition);
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }
}
