package com.adventofcode.y2021.d2;

import com.adventofcode.y2021.d2.Dive.DiveDirection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;

import java.util.*;

public class DiveTest {

    public static final List<AbstractMap.SimpleImmutableEntry<DiveDirection,Integer>>
            controlCourseExample = Collections.unmodifiableList(Arrays.<AbstractMap.SimpleImmutableEntry<DiveDirection,Integer>>asList(
            new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,5)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.down,5)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,8)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.up,3)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.down,8)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,2)
    ));

    @InjectMocks
    Dive dive;

    List<AbstractMap.SimpleImmutableEntry<DiveDirection,Integer>> controlCourse;

    @BeforeEach
    void before(){
        dive = new Dive();
        controlCourse = controlCourseExample;
    }

    @Test
    @DisplayName("Given no course is planned then the horizontal position is 0")
    void testHorizontalPositionWithoutCourse(){
        assertEquals(0, dive.getHorizontalPosition());
    }


    @Test
    @DisplayName("Given no course is planned then the depth is 0")
    void testDepthWithoutCourse(){
        assertEquals(0, dive.getDepth());
    }

    @Test
    @DisplayName("Given the example input then the horizontal position is 15")
    void testHorizontalPositionFromExample(){
        dive.setPlannedCourse(controlCourse);
        assertEquals(10,dive.getHorizontalPosition());
    }

    @Test
    @DisplayName("Given the example input then the depth is 10")
    void testDiveFromExample(){
        dive.setPlannedCourse(controlCourse);
        assertEquals(10, dive.getDepth());
    }
}
