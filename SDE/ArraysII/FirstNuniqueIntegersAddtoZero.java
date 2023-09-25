package SDE.ArraysII;

public class FirstNuniqueIntegersAddtoZero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        
        int l=0;
        int r=n-1;
        
        int ele = 1;
        
        while(l<r){
            ans[l++]=ele;
            ans[r--]=-ele;
            ele++;
        }
        
        return ans;
    }
}
