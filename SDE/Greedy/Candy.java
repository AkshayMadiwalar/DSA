package SDE.Greedy;

public class Candy {
    public int candy(int[] ratings) {
        
        int[] prefix = new int[ratings.length];
        int[] suffix = new int[ratings.length];
        
        for(int i=0;i<ratings.length;i++){
            if(i==0){
                prefix[i]=0;
            }
            else{
                if(ratings[i]>ratings[i-1])
                    prefix[i]=prefix[i-1]+1;
            }
        }
                
        for(int i=ratings.length-1;i>=0;i--){
            if(i==ratings.length-1){
                suffix[i]=0;
            }
            else{
                if(ratings[i]>ratings[i+1])
                    suffix[i]=suffix[i+1]+1;
            }
        }
        
        int n = 0;
        for(int i=0;i<prefix.length;i++){
            n+=Math.max(prefix[i],suffix[i]);
        }
        
        return n+ratings.length;
    }
}
