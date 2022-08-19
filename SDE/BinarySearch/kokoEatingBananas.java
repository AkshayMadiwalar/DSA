package SDE.BinarySearch;

public class kokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int hi=1;
        for(int i=0;i<piles.length;i++)
            hi=Math.max(hi,piles[i]);
        int min = Integer.MAX_VALUE;
        while(l<hi){
            int mid = (l+hi)/2;
            int speed = calculateSpeed(piles,mid);
            if(speed<=h)
                hi=mid;
            else
                l=mid+1;
        }
        return hi;
    }
    
    public int calculateSpeed(int[] piles, int ele){
        int speed = 0;
        for(int i=0;i<piles.length;i++){
            speed+=Math.ceil((double)piles[i]/ele);
        }
        return speed;
    }
}
