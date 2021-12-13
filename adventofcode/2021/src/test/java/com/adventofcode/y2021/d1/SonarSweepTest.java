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

    public  static final int EXAMPLE_EXPECTED_COUNT_INCREASES= 7;

    public static  final int ANSWER_1 = 1121;
    public static  final int ANSWER_2 = 2343233;

    public static final List<Integer> seaFloorDepthsExample =
            Collections.unmodifiableList(Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263 ));

    SonarSweep sonarSweepPuzzle;
    SonarSweepReport sonarSweepReportPuzzle;

    @InjectMocks
    SonarSweep sonarSweep;

    @Mock
    SonarSweepReport sonarSweepReport;

    List<Integer> seaFloorDepths;

    @BeforeEach
    void before(){

        seaFloorDepths = seaFloorDepthsExample;

        sonarSweepReportPuzzle = new SonarSweepReport();
        sonarSweepReportPuzzle.load(SonarSweepInput.SONAR_SWEEP_INPUT);
        sonarSweepPuzzle = new SonarSweep();
        sonarSweepPuzzle.setSonarSweepReport(sonarSweepReportPuzzle);
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

        assertEquals(ANSWER_1,sonarSweepPuzzle.countIncreases());
        System.out.println("FIRST PUZZLE ANSWER IS " + ANSWER_1);
    }

}
