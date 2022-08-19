package SDE.ArraysII;

import java.util.*;

public class IntervalsIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> ans = new ArrayList<>();
        
        int i=0;
        int j=0;
        
        while(i<firstList.length && j<secondList.length){
            
            if(Math.max(firstList[i][0],secondList[j][0]) <= Math.min(firstList[i][1],secondList[j][1])){
                //there is an intersection
                int start = Math.max(firstList[i][0],secondList[j][0]);
                int end = Math.min(firstList[i][1],secondList[j][1]);
                int[] res = new int[]{start,end};
                ans.add(res);
            }
            
            if(firstList[i][1]>secondList[j][1])
                j++;
            else
                i++;
        }
        
        int[][] a = new int[ans.size()][2];
        
        for(int k=0;k<ans.size();k++){
            a[k][0]=ans.get(k)[0];
            a[k][1]=ans.get(k)[1];
        }
        
        return a;
    }
}
