package SDE.ArraysII;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
   
        int i = 0;
        int j= 0;
        int k=0;
        int[] temp = new int[nums1.length];
        
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                temp[k] = nums1[i];
                k++;
                i++;
            }
            else{
                temp[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i<m){
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            temp[k]=nums2[j];
            j++;
            k++;
        }
        
        for(int z=0;z<temp.length;z++){
            nums1[z]=temp[z];
        }
    }
}
