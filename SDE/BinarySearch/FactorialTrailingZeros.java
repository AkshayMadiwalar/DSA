package SDE.BinarySearch;

public class FactorialTrailingZeros {

    //---Log base 5 (N)
    public int trailingZeroes(int n) {
        int c= 0;
        while(n>0){
            n=n/5;
            c+=n;
        }
        return c;
    }
}
