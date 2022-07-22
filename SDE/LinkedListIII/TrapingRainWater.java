package SDE.LinkedListIII;

public class TrapingRainWater {
    
    public int trap(int[] height) {
        
        int[] pmax = new int[height.length];
        int[] smax = new int[height.length];
        
        int pm=height[0];
        int sm=height[height.length-1];
        
        for(int i=0;i<height.length;i++){
            if(pm<height[i])
                pm=height[i];
            pmax[i]=pm;
        }
        
        for(int i=height.length-1;i>=0;i--){
            if(sm<height[i])
                sm=height[i];
            smax[i]=sm;
        }
        
        int sum = 0;
        
        for(int i=0;i<height.length;i++){
            if(Math.min(pmax[i],smax[i])-height[i]>0){
                sum+=Math.min(pmax[i],smax[i])-height[i];
            }
        }
        return sum;
        
    }
}
