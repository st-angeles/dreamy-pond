package com.adventofcode.y2021.d7;

import com.adventofcode.y2021.d7.input.CrabSwarmInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.y2021.d7.Crab;

import java.util.*;

public class CrabSwarmTest {
    CrabSwarm crabSwarm;

    public static final List<Crab>
            CRABS_INPUT_FROM_EXAMPLE = Collections.unmodifiableList(
                    Arrays.asList(
                            new Crab(16)
                            ,new Crab(1)
                            ,new Crab(2)
                            ,new Crab(0)
                            ,new Crab(4)
                            ,new Crab(2)
                            ,new Crab(7)
                            ,new Crab(1)
                            ,new Crab(2)
                            ,new Crab(14)
    ));

    public static final int EXPECTED_MIN_FUEL_FROM_EXAMPLE = 37;

    @BeforeEach
    void beforeEach(){
        crabSwarm =  new CrabSwarm();
    }

    @Test
    @DisplayName("Given a swarm of crabs when their horizontal position matches the example input then the minimum required fuel is " + EXPECTED_MIN_FUEL_FROM_EXAMPLE)
    void testMinRequiredFuelForExampleInput(){
        crabSwarm.setCrabs(CRABS_INPUT_FROM_EXAMPLE);
        assertEquals(EXPECTED_MIN_FUEL_FROM_EXAMPLE, crabSwarm.getMinTotalRequiredFuel());
    }

    @Test
    @DisplayName("")
    void testMinRequiredFuelForPuzzleInput(){
        crabSwarm.setCrabs(CrabSwarmInput.CRABS_INPUT);
        assertEquals(0,crabSwarm.getMinTotalRequiredFuel());
    }
}
