package SDE.ArraysIV;

import java.util.HashMap;

public class FoursSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int s=nums1[i]+nums2[j];
                if(!map.containsKey(s)){
                    map.put(s,1);
                }
                else{
                    map.put(s,map.get(s)+1);
                }
            }
        
        int c=0;
        for(int k=0;k<n;k++)
            for(int l=0;l<n;l++){
                int s=(nums3[k]+nums4[l])*-1;
                if(map.containsKey(s)){
                    c+=map.get(s);
                }
            }    
        return c;
    }
}
