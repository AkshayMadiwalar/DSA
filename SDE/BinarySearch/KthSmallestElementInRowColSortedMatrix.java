package SDE.BinarySearch;

public class KthSmallestElementInRowColSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n= matrix[0].length;
        
        int l = matrix[0][0];
        int h = matrix[m-1][n-1];
        
        int elements = m*n-k;
        
        while(l<h){
            int mid = l+(h-l)/2;
            int no_of_greater_elements = count(matrix,mid);
            if(no_of_greater_elements>elements)
                l=mid+1;
            else 
                h=mid;
        }
        return h;
    }
    
    public int count(int[][] matrix, int ele){
        int c = 0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]>ele)
                    c++;
            }
        return c;
    }
}
