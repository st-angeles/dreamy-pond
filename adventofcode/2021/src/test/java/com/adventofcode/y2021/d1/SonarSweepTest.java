package com.adventofcode.y2021.d1;

import com.adventofcode.util.MockitoExtension;
import com.adventofcode.y2021.d1.input.SonarSweepInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SonarSweepTest {

    public  static final int EXAMPLE_EXPECTED_COUNT_INCREASES = 7;
    public  static final int EXAMPLE_EXPECTED_COUNT_INCREASE_3W = 5;

    public static  final int ANSWER_1 = 1121;
    public static  final int ANSWER_2 = 1065;

    public static final List<Integer> seaFloorDepthsExample =
            Collections.unmodifiableList(Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263 ));

    @InjectMocks
    SonarSweep sonarSweep;

    @Spy
    SonarSweepReport sonarSweepReport;

    List<Integer> seaFloorDepths;

    @BeforeEach
    void before(){
        seaFloorDepths = seaFloorDepthsExample;
    }

    @Test
    void testInsufficientSweeps(){
        when(sonarSweepReport.getSeaFloorDepths()).thenReturn(Arrays.asList(123));
        assertThrows(RuntimeException.class, () -> sonarSweep.countIncreases());
    }

    @Test
    void testCountIncreasesFromExample(){
        when(sonarSweepReport.getSeaFloorDepths()).thenReturn(seaFloorDepths);
        assertEquals(sonarSweepReport,sonarSweep.getSonarSweepReport());
        assertEquals(EXAMPLE_EXPECTED_COUNT_INCREASES, sonarSweep.countIncreases());
    }

    @Test
    @DisplayName("How many measurements are larger than the previous measurement?")
    void testNumberOfIncreasesForPuzzleInput(){

        sonarSweep = new SonarSweep();
        assertThrows(RuntimeException.class, () -> sonarSweep.countIncreases());

        sonarSweepReport = new SonarSweepReport();
        sonarSweepReport.load(SonarSweepInput.SONAR_SWEEP_INPUT);

        sonarSweep.setSonarSweepReport(sonarSweepReport);
        assertEquals(sonarSweep.getSonarSweepReport().getSeaFloorDepths(), SonarSweepInput.SONAR_SWEEP_INPUT);

        assertEquals(ANSWER_1,sonarSweep.countIncreases());
        System.out.println("FIRST PUZZLE ANSWER IS " + ANSWER_1);
    }

    @Test
    void testNumberOfIncrease3WindowsFromExample(){
        when(sonarSweepReport.getSeaFloorDepths()).thenReturn(seaFloorDepthsExample);
        assertEquals(sonarSweepReport,sonarSweep.getSonarSweepReport());
        assertEquals(EXAMPLE_EXPECTED_COUNT_INCREASE_3W, sonarSweep.countIncreases3W());
    }

    @Test
    @DisplayName("Consider sums of a three-measurement sliding window. How many sums are larger than the previous sum?")
    void testNumberOfIncreases3WindowForPuzzleInput(){

        sonarSweep = new SonarSweep();
        assertThrows(RuntimeException.class, () -> sonarSweep.countIncreases());

        sonarSweepReport = new SonarSweepReport();
        sonarSweepReport.load(SonarSweepInput.SONAR_SWEEP_INPUT);

        sonarSweep.setSonarSweepReport(sonarSweepReport);
        assertEquals(sonarSweep.getSonarSweepReport().getSeaFloorDepths(), SonarSweepInput.SONAR_SWEEP_INPUT);
        sonarSweepReport.load(sonarSweepReport.getSeaFloorDepths3W());

        assertEquals(ANSWER_2,sonarSweep.countIncreases());
        System.out.println("SECOND PUZZLE ANSWER IS " + ANSWER_2);
    }

}
