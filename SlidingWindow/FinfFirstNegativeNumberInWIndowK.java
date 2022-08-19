package SlidingWindow;

import java.util.*;

public class FinfFirstNegativeNumberInWIndowK {
    

    //Time O(N)
    //space O(N)
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int start = 0;
        int end = 0;
        
        List<Long> nlist = new ArrayList<>();
        List<Long> ans = new ArrayList<>(); 
        
        while(end<N){
            
            if(A[end] < 0) nlist.add(A[end]);
               
            if(end-start+1 < K){
                end++;
            }
            else if(end-start+1 == K){
             
                if(nlist.size()>0)
                    ans.add(nlist.get(0));
                else
                    ans.add(0L);
                


                if(nlist.contains(A[start])){
                    nlist.remove(0);
                }
                start++;
                end++;
            }
        }
        
        long[] res = new long[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
