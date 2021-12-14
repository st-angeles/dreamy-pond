package com.adventofcode.y2021.d2;

public class DeepDive extends Dive {

    public int getAim(){

        return super.getDepth();
    }

    @Override
    public int getDepth() {

        return getAim() * super.getHorizontalPosition();
    }

}
