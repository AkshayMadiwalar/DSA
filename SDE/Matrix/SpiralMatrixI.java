package SDE.Matrix;

import java.util.*;

public class SpiralMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int top_row = 0;
        int right_col = matrix[0].length-1;
        int bot_row = matrix.length-1;
        int left_col = 0;
        
        List<Integer> ans = new ArrayList<Integer>();
        
        while(top_row<bot_row && left_col<right_col){
            
            for(int i=left_col;i<=right_col;i++){
                ans.add(matrix[top_row][i]);
            }
            
            for(int i=top_row+1;i<=bot_row;i++){
                ans.add(matrix[i][right_col]);
            }
            
            for(int i=right_col-1;i>=left_col;i--){
                ans.add(matrix[bot_row][i]);
            }
            
            for(int i=bot_row-1;i>top_row;i--){
                ans.add(matrix[i][left_col]);
            }
            
            top_row++;
            bot_row--;
            left_col++;
            right_col--;
        }
        
        if(top_row==bot_row){
            for(int i=left_col;i<=right_col;i++)
                ans.add(matrix[top_row][i]);
            left_col++;
            right_col--;
        }
        
        if(left_col==right_col && top_row!=bot_row){
            for(int i=top_row;i<=bot_row;i++){
                ans.add(matrix[i][left_col]);
            }
        }
        return ans;
    }
}
