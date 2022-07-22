package SDE.RecursionAndBacktracking;
import java.util.*;;

public class NQueens {
    
    public boolean isSafe(List<String> board, int row, int col, int n){
        int crow = row;
        int ccol = col;
        
        while(row>=0 && col>=0){
            if(board.get(row).charAt(col)=='Q')    return false;
            row--;
            col--;
        }
        
        row=crow;
        col=ccol;
        
        while(col>=0){
            if(board.get(row).charAt(col)=='Q')    return false;
            col--;
        }
        
        row=crow;
        col=ccol;
        
        while(row<n && col>=0){
            if(board.get(row).charAt(col)=='Q')    return false;
            row++;
            col--;
        }
        
        return true;
    }

//board=>
//[". . . .",". . . .",". . . .",". . . ."] List of strings: each string is row

//ans List of boards
//[[board1]
// [board2]]
    
    public void solve(int col, List<String> board, int n, List<List<String>> ans){
        if(col==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        
        for(int row=0;row<n;row++){
            if(isSafe(board,row,col,n)){
                
                //board[row][col]='Q'
                //solve(col+1,board,n,ans)
                //board[row][col]='.'    ---> backtrack
                
                String str= board.get(row);
                str = str.substring(0, col) + 'Q' + str.substring(col + 1);
                board.set(row,str); 
            
                solve(col+1,board,n,ans);
            
                
                str = str.substring(0, col) + '.' + str.substring(col + 1);
                board.set(row,str); 
            }
        }    
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s= "";
            for(int j=0;j<n;j++){
                s=s+'.';
            }
            board.add(s);
        }
        solve(0,board,n,ans);
        return ans;
    }
}




