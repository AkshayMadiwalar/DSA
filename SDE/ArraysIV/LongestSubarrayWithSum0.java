package SDE.ArraysIV;

import java.util.HashMap;

public class LongestSubarrayWithSum0 {


    //Time O(N)
    //Space O(N)
    int longestSubarraySumZero(int arr[], int n)
    {
        // Your code here
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == 0){
                max = i+1;
            }else{
                if(map.get(sum)==null){
                    map.put(sum,i);
                }else{
                    if(max < (i-map.get(sum)))
                        max = i - map.get(sum);
                }
            }
        }
        
        return max;
    }
}
