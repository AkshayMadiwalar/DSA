public class FloorOfX {
    
class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    int findFloor(long arr[], int n, long x)
    {
        int l = 0;
        int h = arr.length-1;
        
        int res = -1;
    
        while(l<h){
            int m = (h+l)/2;
            
            if(x>=arr[h]){
                return h;
            }
            
            if(arr[m]<=x){
                res = m;
                l=m+1;
            }
            else
                h=m;
        }
        
        return res;
        
    }
    
}
}
