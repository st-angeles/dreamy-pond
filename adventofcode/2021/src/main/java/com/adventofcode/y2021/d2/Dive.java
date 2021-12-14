package com.adventofcode.y2021.d2;

import java.util.AbstractMap;
import java.util.List;

public class Dive {

    public enum DiveDirection{
        forward,
        up,
        down
    }

    private List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> plannedCourse;

    public List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> getPlannedCourse() {
        return plannedCourse;
    }

    public void setPlannedCourse(List<AbstractMap.SimpleImmutableEntry<DiveDirection, Integer>> plannedCourse) {
        this.plannedCourse = plannedCourse;
    }

    public int getHorizontalPosition(){
        return 0;
    }

    public int getDepth(){
        return 0;
    }

}
