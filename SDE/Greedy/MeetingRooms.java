package SDE.Greedy;

import java.util.Arrays;

public class MeetingRooms {
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0]=start[i];
            intervals[i][1]=end[i];
        }
        
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        
        int s=intervals[0][0];
        int e=intervals[0][1];
        int count=1;
        for(int i=1;i<n;i++){
            if(intervals[i][0]>e){
                count++;
                s=intervals[i][0];
                e=intervals[i][1];
            }
        }
        
        return count;
    }
}
