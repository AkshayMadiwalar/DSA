package Graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        
        int[][] visited = new int[board.length][board[0].length];
        
        for(int col=0;col<board[0].length;col++){
            if(visited[0][col]==0)
                dfs(board,0,col,visited);
            if(visited[board.length-1][col]==0)
                dfs(board,board.length-1,col,visited);
        }
        
        for(int row=0;row<board.length;row++){
            if(visited[row][0]==0)
                dfs(board,row,0,visited);
            if(visited[row][board[0].length-1]==0)
                dfs(board,row,board[0].length-1,visited);
        }
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O')    board[i][j]='X';
                if(board[i][j]=='.')    board[i][j]='O';
            }
    }
    
    public void dfs(char[][] board, int i , int j, int[][] visited){
        visited[i][j]=1;
        
        if(board[i][j]=='O')
            board[i][j]='.';
        else
            return;
        
        if(i>0 && board[i-1][j]=='O' && visited[i-1][j]==0)
            dfs(board,i-1,j,visited);
        
         if(i<board.length-1 && board[i+1][j]=='O' && visited[i+1][j]==0)
            dfs(board,i+1,j,visited);
        
        if(j>0 && board[i][j-1]=='O' && visited[i][j-1]==0)
            dfs(board,i,j-1,visited);
        
        if(j<board[0].length-1 && board[i][j+1]=='O' && visited[i][j+1]==0)
            dfs(board,i,j+1,visited);
    }
}
