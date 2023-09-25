package SDE.BinarySearch;

public class SquareRootOfNumber {
    long floorSqrt(long x)
	 {
		// Your code here
		long l = 1;
		long h = x;
		
		long ans = -1L;
		
		while(l<=h){
		    long m = (l+h)/2;
		    
		    long prod = m*m;
		    
		    if(prod == x)
		        return m;
		        
		    if(prod<x){
		        ans = m;
		        l=m+1;
		    }
		    else
		        h=m-1;
		}
		
		return ans;
	 }
}
