package SDE.Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=1;
        int j=0;
        int platforms=1;
        int max=platforms;
        
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            
            max=Math.max(max,platforms);
        }
        return max;
    }
}
