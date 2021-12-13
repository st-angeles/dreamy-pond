package com.adventofcode.y2021.d1;
import java.util.List;
import java.util.ArrayList;

public class SonarSweep {

    enum SweepLevel{
        N_A,
        DECREASED,
        INCREASED
    }

    private SonarSweepReport sonarSweepReport;

    public long countIncreases() throws  RuntimeException{
        if(sonarSweepReport == null || !( sonarSweepReport.getSeaFloorDepths().size() >= 2)) {
            throw new RuntimeException("Insufficient sweeps !");
        }
        else
        {
            List<Integer> depths = sonarSweepReport.getSeaFloorDepths();
            List<SweepLevel> levels = new ArrayList<>(0);
            levels.add(SweepLevel.N_A);
            for( int i = 1; i < depths.size(); i++) {
                int diff = depths.get(i) - depths.get(i - 1);
                if (diff > 0) {
                    levels.add(SweepLevel.INCREASED);
                } else {
                    levels.add(SweepLevel.DECREASED);
                }
            }
            
            return levels.stream()
                    .filter(x -> x == SweepLevel.INCREASED)
                    .count();
        }
    }

    public void setSonarSweepReport(SonarSweepReport sonarSweepReport) {
        this.sonarSweepReport = sonarSweepReport;
    }

    SonarSweepReport getSonarSweepReport() {

        return sonarSweepReport;
    }
}
