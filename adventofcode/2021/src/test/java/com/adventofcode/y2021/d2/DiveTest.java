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
            CONTROL_COURSE_EXAMPLE = Collections.unmodifiableList(Arrays.<AbstractMap.SimpleImmutableEntry<DiveDirection,Integer>>asList(
            new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,5)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.down,5)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,8)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.up,3)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.down,8)
            ,new AbstractMap.SimpleImmutableEntry(DiveDirection.forward,2)
    ));

    public static final int EXPECTED_HORIZ_POS_EXAMPLE = 15;
    public static final int EXPECTED_DEPTH_EXAMPLE = 10;

    Dive dive;

    List<AbstractMap.SimpleImmutableEntry<DiveDirection,Integer>> controlCourse;

    @BeforeEach
    void before(){
        dive = new Dive();
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
        dive.setPlannedCourse(CONTROL_COURSE_EXAMPLE);
        assertEquals(EXPECTED_HORIZ_POS_EXAMPLE,dive.getHorizontalPosition());
    }

    @Test
    @DisplayName("Given the example input then the depth is 10")
    void testDiveFromExample(){
        dive.setPlannedCourse(CONTROL_COURSE_EXAMPLE);
        assertEquals(EXPECTED_DEPTH_EXAMPLE, dive.getDepth());
    }
}
