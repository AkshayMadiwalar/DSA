package SDE.ArraysIII;

public class Search2Dmatrix {

    //O(Log(nm))
    public boolean searchMatrix(int[][] matrix, int target) {
        
        boolean ans = false;
        
        if(matrix.length == 0){
            return ans;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = 0 ;
        int high = (n*m)-1;
        
        while(low<=high){

            //mid calculation: low + (high-low)/2  in 2d matrix indexes
            int mid = (low+(high-low)/2);

            //row index: mid/col_length
            //col index: mid%col_length
            if(matrix[mid/m][mid%m] == target){
                ans = true;
                break;
            }
            if(matrix[mid/m][mid%m] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return ans;
        
        
    }
}
