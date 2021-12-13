package com.adventofcode.y2021.d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SonarSweepReport {
  private List<Integer> seaFloorDepths = new ArrayList(0);

  public SonarSweepReport(){
      seaFloorDepths = new ArrayList<>(0);
  }

  public List<Integer> getSeaFloorDepths(){

      return Collections.unmodifiableList(seaFloorDepths);
  }

  public List<Integer> getSeaFloorDepths3W(){
      List<Integer> depths3W = new ArrayList<>(0);
      for( int i = 0 ; i < seaFloorDepths.size() - 2 ; i++){
          int sum3W = seaFloorDepths.get(i) + seaFloorDepths.get(i + 1) + seaFloorDepths.get(i + 2);
          depths3W.add(sum3W);
      }

      return Collections.unmodifiableList(depths3W);
  }

  public void add(int depth){
      seaFloorDepths.add(depth);
  }

  public void load(List<Integer> depths){
      if(seaFloorDepths != null && seaFloorDepths.size() >= 0) {
          seaFloorDepths.clear();
          for (Integer i : depths) {
              add(i);
          }
      }
  }
}
