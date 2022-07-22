package SDE.ArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    //Time: O(NlongN) sorting + O(N) merging
    public int[][] merge(int[][] intervals) {
        

        //sort the intervals
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        List<int[]> ans = new ArrayList<>();
        
        
        //merge
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            }else{
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[0][]);
    }
}
