package com.adventofcode.y2021.d2;

import java.util.AbstractMap;
import java.util.List;

public class Dive {

    public enum DiveDirection{
        forward,
        up,
        down
    }

    protected List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> plannedCourse;

    public List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> getPlannedCourse() {
        return plannedCourse;
    }

    public void setPlannedCourse(List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> plannedCourse) {
        this.plannedCourse = plannedCourse;
    }

    public int getHorizontalPosition(){
        if( plannedCourse == null) {
            return 0;
        }

        return plannedCourse.stream()
                            .filter(e -> e.getKey() == DiveDirection.forward)
                            .mapToInt(e -> e.getValue())
                            .sum();
    }

    public int getDepth(){
        if(plannedCourse == null) {
            return 0;
        }

        int down = plannedCourse.stream()
                                     .filter(e -> e.getKey() == DiveDirection.down)
                                     .mapToInt(e -> e.getValue())
                                     .sum();

        int up = plannedCourse.stream()
                                   .filter(e -> e.getKey() == DiveDirection.up)
                                   .mapToInt(e -> e.getValue())
                                   .sum();

        return down - up;
    }

}
