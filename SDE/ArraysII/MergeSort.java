package SDE.ArraysII;

public class MergeSort {
    public void mergeSort(int[] nums, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(nums,l,m);
            mergeSort(nums,m+1,r);
            
            merge(nums,l,m,r);
        }
    }
    
    public void merge(int[] nums, int l, int m, int r){
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
        
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                nums[k]=a[i];
                k++;
                i++;
            }else{
                nums[k]=b[j];
                k++;
                j++;
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
    }
    
    public int[] sortArray(int[] nums) {
       mergeSort(nums,0,nums.length-1);
        return nums;
    }
}
