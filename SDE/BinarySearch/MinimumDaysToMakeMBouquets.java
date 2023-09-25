package SDE.BinarySearch;

public class MinimumDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if(m*k > bloomDay.length)
            return -1;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int day:bloomDay){
            min=Math.min(min,day);
            max=Math.max(max,day);
        }
        
        while(min<max){
            int mid = min + (max - min) / 2;
            
            int possibleBq = countBqs(bloomDay, mid, k);
            
            if(possibleBq>=m){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        
        return max;
    }

    
    public int countBqs(int[] bloomDay, int day, int flowers){
        int bqs = 0;
        int flowersCollected = 0;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                flowersCollected++;
            }
            else{
                flowersCollected=0;
            }
            
            if(flowersCollected == flowers){
                bqs++;
                flowersCollected = 0;
            }
        }
        
        return bqs;
    }
}
