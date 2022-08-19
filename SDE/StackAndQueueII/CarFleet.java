package SDE.StackAndQueueII;

import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stk = new Stack<>();
        
        int[][] cars = new int[position.length][2];
        
        for(int i=0;i<position.length;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        
        Arrays.sort(cars,(a,b)->a[0]-b[0]);
        
        for(int i=position.length-1;i>=0;i--){
            double time = (double) (target-cars[i][0])/cars[i][1];
            
            if(stk.size()>0 && stk.peek()>=time)
                continue;
            else
                stk.push(time);
        }
        
        return stk.size();
    }
}
