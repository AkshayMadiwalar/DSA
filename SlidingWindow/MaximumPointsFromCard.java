package SlidingWindow;

public class MaximumPointsFromCard {
    public int maxScore(int[] cardPoints, int k) {
        int start = 0;
        int end = cardPoints.length-1;
        int sum = 0;
        int max =0;
        
        while(start<k){
            sum+=cardPoints[start];
            start++;
        }
        
        max=Math.max(max,sum);
        
        if(start==cardPoints.length)
            return max;
        
        start=start-1;       
        sum-=cardPoints[start];
        start=start-1;
        
        while(end>=cardPoints.length-k){
            sum+=cardPoints[end];
            max=Math.max(max,sum);
            if(start>=0){
                sum-=cardPoints[start];
                start--;
            }
            end--;
        }  
        return max;
    }
}
