public class MaxSubarraySumWithSizeK {

    //SLiding window
    //Time O(N)
    //Space O(1)
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int start = 0;
        int end = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        
        while(end<N){
            if(end-start+1 < K){
                sum+=Arr.get(end);
                end++;
            }
            else{
                sum+=Arr.get(end);
                max = Math.max(max,sum);
                sum-=Arr.get(start);
                start++;
                end++;
            }
        }
        
        return max;
    }
}
