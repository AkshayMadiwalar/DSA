package SDE.ArraysII;

public class CountInversions {
    public int mergeSort(int[] nums, int l, int r){
        int count = 0;
        if(l<r){
            int m = (l+r)/2;
            count+=mergeSort(nums,l,m);  //Left array inversions
            count+=mergeSort(nums,m+1,r); // Right array Inversions
            
            count+=merge(nums,l,m,r);  // inversions after merging
        }
        return count;
    }
    
    public int merge(int[] nums, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int  a[] = new int[n1];
        int  b[] = new int[n2];
        
        for(int i=0;i<n1;i++){
            a[i]=nums[l+i];
        }
        for(int j=0;j<n2;j++){
            b[j]=nums[m+1+j];
        }
        
        int i=0,j=0,k=l;
        int swaps = 0;

        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                nums[k]=a[i];
                k++;
                i++;
            }else{
                nums[k]=b[j];
                k++;
                j++;
                swaps = (m+1)-(l+i);  //count inversions
            }
        }
        while(i<n1){
            nums[k]=a[i];
            k++;
            i++;
        }
        while(j<n2){
            nums[k]=b[j];
            k++;
            j++;
        }
        return swaps;  //return inversions
    }
}
