public class SetMatrixZeros {

    //use row and cols extra space 
    // time=> O(n*m)
    // space=> O(n+m)
    public void setZeroes(int[][] matrix) {
        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            rows[i]=1;
        }
        
        for(int j=0;j<cols.length;j++){
            cols[j]=1;
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(rows[i]==0 || cols[j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
