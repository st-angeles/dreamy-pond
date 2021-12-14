package com.adventofcode.y2021.d2;

import java.util.AbstractMap;

public class DeepDive extends Dive {

    int partialDepth = 0;
    int partialAim = 0;

    public int getAim(){

        return super.getDepth();
    }

    @Override
    public int getDepth() {

        if(plannedCourse == null) {
            return 0;
        }

        plannedCourse.stream()
                .forEach(e -> setPartials(e));

        return partialDepth;
    }

    private void setPartials(AbstractMap.SimpleImmutableEntry<Dive.DiveDirection,Integer> e){
        switch(e.getKey()){
            case down:
                partialAim += e.getValue();
                break;
            case up:
                partialAim -= e.getValue();
                break;
            case forward:
                partialDepth += partialAim * e.getValue();
                break;
        }
    }
}
