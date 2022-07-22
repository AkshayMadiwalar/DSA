package SDE.ArraysII;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
                
        for(int i=0;i<intervals.length;i++){
            
            if(newInterval[0]>intervals[i][1]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            
            else if(newInterval[1]<intervals[i][0]){
                list.add(newInterval);
                newInterval = intervals[i];
            }
            
            else{
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        
         list.add(newInterval);
        
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        
        return ans;
    }
}
