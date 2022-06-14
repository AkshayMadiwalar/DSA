public class MaxSubarrayWithGivenSum {
    

    // Hashin method   -------works for negative numers as well-------------------
    // O(N) time O(N) space
    public static int lenOfLongSubarr2(int A[], int N, int K) {
        //Complete the function
        
        int sum = 0;
        int max = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            
            if(sum == K){
               max = i+1;
            }
    
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
            if(map.containsKey(sum-K)){
                if(max < (i-map.get(sum-K))){
                    max = i-map.get(sum-K);
                }
            }
            

        }
        
        return max;
    }

    // Sliding window method
    // -------------works only for positive numbres----------------
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int start = 0;
        int end = 0;
        int max = 0;
        int sum=0;
        
        while(end<N){
            sum+=A[end];
            
            if(sum<K)
                end++;
            else if(sum == K){
                if(max< end-start+1)
                    max = end-start+1;
                end++;
            }
            else{
                while(sum>K){
                    sum-=A[start];
                    start++;
                }
                if(sum==K){
                    if(max< end-start+1)
                        max = end-start+1;
                }
                end++;
            }
        }
        
        return max;
    }
}
