package SDE.Matrix;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        
        int top_row = 0;
        int right_col = n-1;
        int bot_row = n-1;
        int left_col = 0;
        
       int[][] ans = new int[n][n];
        
        int ele=1;
        
        while(top_row<bot_row && left_col<right_col){
            
            for(int i=left_col;i<=right_col;i++){
                ans[top_row][i]=ele++;
            }
            
            for(int i=top_row+1;i<=bot_row;i++){
                ans[i][right_col]=ele++;
            }
            
            for(int i=right_col-1;i>=left_col;i--){
                ans[bot_row][i]=ele++;
            }
            
            for(int i=bot_row-1;i>top_row;i--){
                ans[i][left_col]=ele++;
            }
            
            top_row++;
            bot_row--;
            left_col++;
            right_col--;
        }
        
        if(top_row==bot_row){
            for(int i=left_col;i<=right_col;i++)
                ans[top_row][i]=ele++;
            left_col++;
            right_col--;
        }
        

        return ans;
    }
}
