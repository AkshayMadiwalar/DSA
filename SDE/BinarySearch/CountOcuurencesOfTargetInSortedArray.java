package SDE.BinarySearch;

public class CountOcuurencesOfTargetInSortedArray {
    int count(int[] arr, int n, int x) {
        // code here
        int last = findLast(arr,x);
        int first = findFirst(arr,x);
        if(first == -1 || last == -1)
            return 0;
        
        return last - first + 1;
    }
    
    int findFirst(int[] arr, int x){
        int l = 0;
        int h = arr.length-1;
        int ind = -1;
        
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]>=x){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
            
            if(arr[mid]==x){
                ind = mid;
            }
        }
        
        return ind;
    }
    
    int findLast(int[] arr, int x){
        int l = 0;
        int h = arr.length-1;
        int ind = -1;
        
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]<=x){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
            
            if(arr[mid]==x){
                ind = mid;
            }
        }
        
        return ind;
    }
}
