package com.adventofcode.y2021.d7;

import java.util.List;

public class CrabSwarm {
    private List<Crab> crabs;

    public List<Crab> getCrabs() {
        return crabs;
    }

    public void setCrabs(List<Crab> crabs) {
        this.crabs = crabs;
    }

    public int getTotalRequiredFuel(int newHorizontalPosition){
        return crabs.stream()
                        .mapToInt( e -> e.getRequiredFuel(newHorizontalPosition))
                        .sum();
    }

    public int getMinTotalRequiredFuel(){
        int minFuel = Integer.MAX_VALUE;
        for(Crab c : crabs){
            int fuel = getTotalRequiredFuel(c.getHorizontalPosition());
            if(fuel < minFuel) {
                minFuel = fuel;
            }
        }

        return minFuel;
    }
}
