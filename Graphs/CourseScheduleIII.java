package Graphs;

import java.util.*;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        
        //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b)->b-a);
        
        int time = 0;
        
        for(int[] course: courses){
            
            // add current course to a priority queue
            time+=course[0];
            pq.add(course[0]);
            
            //If time exceeds, drop the previous course which costs the most time.
            if(time>course[1]){
                time=time-pq.poll();
            }
        }
        
        return pq.size();
    }
}
