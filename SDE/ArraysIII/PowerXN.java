package SDE.ArraysIII;

public class PowerXN {
    
    //Power(x,n)
    //Time : O(logN)

    //Approach:
    // if even n=> 2^6  => (2*2)^3
    // if odd n=> 2^5 => 2(2^4)

    //if negative n=> 1/ans 
    
    public double myPow(double x, int n) {
        
        double ans = 1.0;
        
        long nn = n;
        
        if(n<0){
            nn = -1 * nn;
        }
        while(nn>0){
            if(nn%2 == 1){
                ans = ans * x;
                nn = nn -1;
            }else{
                x = x * x;
                nn = nn /2;
            }
        }
        
        if(n<0)
            ans =  (double)(1.0) / (double)(ans);
        return ans;
    }
}
