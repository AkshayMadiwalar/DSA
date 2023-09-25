class Solution
{
    public int gcd(int A , int B) 
    { 
        if(A==B)
            return A;
            
        if(A>B){
            return gcd(A-B,B);
        }
        else
            return gcd(A,B-A);
    } 
    
}