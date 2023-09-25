package SDE.BinarySearch;

public class MinimumCapacityToSipWithinDdays {
    public int shipWithinDays(int[] weights, int days) {
        int min = 1;
        int max = 2500000;
        
        while(min<max){
            int mid = (min+max)/2;
            
            if(canShip(weights,days,mid)){
                max=mid;
            }
            else{
                min=mid+1;
            }            
        }
        
        return max;
    }
    
    
    public boolean canShip(int[] weights, int D,int capacity){
        int w = 0;
        int day = 1;
        
        for(int i=0;i<weights.length;i++){
            
            if(weights[i]>capacity)
                return false;
            
            if(w+weights[i]>capacity){
                day++;
                w=weights[i];
            }else{
                w+=weights[i];
            }
        }
        
        return day<=D;
    }
}
