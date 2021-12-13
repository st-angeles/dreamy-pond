package com.adventofcode.y2021.d1;
import java.util.List;
import java.util.ArrayList;

public class SonarSweep {

    public enum SweepLevel{
        N_A,
        DECREASED,
        INCREASED
    }

    class Counter{
        private int counter;
        private int SIZE;

        public Counter(){
            SIZE = 1;
            counter = 0;
        }

        public Counter(int size){
            SIZE = size;
            counter = 0;
        }

        public void inc(){
            counter = (counter + 1 ) % SIZE;
        }

        public int value(){
            return counter;
        }
    }

    private SonarSweepReport sonarSweepReport;

    long countIncreases() throws  RuntimeException{
        if(sonarSweepReport == null || !( sonarSweepReport.getSeaFloorDepths().size() >= 2)) {
            throw new RuntimeException("Insufficient sweeps !");
        }
        else
        {
            List<Integer> seaFloorDepths = sonarSweepReport.getSeaFloorDepths();
            Counter idx = new Counter(seaFloorDepths.size());
            long count = seaFloorDepths.stream()
                    .map( (x) -> SweepLevelMapper(x, idx, seaFloorDepths))
                    .filter(x -> x == SweepLevel.INCREASED)
                    .count();
            return count;
        }
    }

    public static SweepLevel SweepLevelMapper(Integer x, Counter idx, List<Integer> depths){
        SweepLevel level;
        if(idx.value() == 0){
            level = SweepLevel.N_A;
        } else {
            int depthDiff = x - depths.get(idx.value() - 1);
            level =  (depthDiff > 0) ? SweepLevel.INCREASED : SweepLevel.DECREASED;
        }
        idx.inc();

        return level;
    }

    public void setSonarSweepReport(SonarSweepReport sonarSweepReport) {
        this.sonarSweepReport = sonarSweepReport;
    }

    public SonarSweepReport getSonarSweepReport() {

        return sonarSweepReport;
    }
}
