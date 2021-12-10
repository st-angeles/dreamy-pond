package com.adventofcode.y2021.d1;

import com.adventofcode.util.MockitoExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SonarSweepTest {

    public  static final int EXAMPLE_EXPECTED_COUNT_INCREASES= 7;

    @InjectMocks
    SonarSweep sonarSweep;

    @Mock
    SonarSweepReport sonarSweepReport;

    List<Integer> seaFloorDepths;

    @BeforeEach
    void before(){
        seaFloorDepths =
            Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263 );
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
}
