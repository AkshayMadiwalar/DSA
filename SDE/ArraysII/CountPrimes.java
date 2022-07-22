package SDE.ArraysII;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] nonprimes = new boolean[n];
        if(n/2==0)
            return 0;
        nonprimes[1]=true;
        int nprimes = 1;
        for(int i=2;i<n;i++){
            if(nonprimes[i]==true)
                continue;
            int j=i*2;
            while(j<n){
                if(!nonprimes[j]){
                    nprimes++;
                    nonprimes[j]=true;
                }
                j=j+i;
            }
        }
        return n-1-nprimes;
    }
}
