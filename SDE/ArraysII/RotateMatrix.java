package SDE.ArraysII;

public class RotateMatrix{
    public void rotate(int[][] matrix) {
        
        //Get transpose of the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        

        //reverse the rows for 90 degree rotation
        for(int i=0;i<matrix.length;i++){
            int start = 0;
            int end = matrix[i].length-1;
            
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
            
        }
        
    }
}