package SDE.Greedy;

public class MaxDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        
        int dist = (int)Math.pow(10,9)*-1;
        int pos = -1;
        int start=-1;
        
        if(seats[0]==0)
            pos = 0;
        
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0)
                continue;
            if(seats[i]==1 && start==-1){
                dist=Math.max(dist,i);
                pos=dist;
                start=i;
            }
            if(seats[i]==1 && start!=-1){
                if(pos<(i-start)/2){
                    dist=i-start;
                    pos = dist/2;
                }
                start=i;
            }
        }
        if(start!=-1){
            if(pos<seats.length-1-start){
                pos = seats.length-1-start;
            }
        }
        
        return pos;
    }
}
