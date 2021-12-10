package com.adventofcode.y2021.d1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SonarSweep {

    private SonarSweepReport sonarSweepReport;

    public long countIncreases() throws  RuntimeException{
        if(sonarSweepReport == null || !( sonarSweepReport.getSeaFloorDepths().size() >= 2)) {
            throw new RuntimeException("Insufficient sweeps !");
        }
        else
        {
            List<Integer> seaFloorDepths = sonarSweepReport.getSeaFloorDepths();
            long count = seaFloorDepths.stream()
                                       .map(this::IncDecMapper)
                                       .filter(x -> x.equals("increased"))
                                       .count();
            return count;
        }
    }

    public String IncDecMapper(int x){
        List<Integer>  seaFloorDepths = sonarSweepReport.getSeaFloorDepths();
        int idx = seaFloorDepths.indexOf(x);
        if(idx == 0){
            return "none";
        } else {
            int depthDiff = x - seaFloorDepths.get(idx - 1);
            return  (depthDiff > 0) ? "increased" : "decreased";
        }
    }

    public void setSonarSweepReport(SonarSweepReport sonarSweepReport) {
        this.sonarSweepReport = sonarSweepReport;
    }

    public SonarSweepReport getSonarSweepReport() {

        return sonarSweepReport;
    }
}
