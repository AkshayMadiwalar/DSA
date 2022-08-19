package Graphs;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board,click[0],click[1]);
        return board;
    }
    
    public void dfs(char[][] board, int r, int c){
        if(r<0 || c<0 || r>=board.length || c>= board[0].length)
            return;
        
        if(board[r][c] == 'M'){
            board[r][c] = 'X';
            return;
        }
        
        int count = 0;
        for(int i=-1;i<2;i++){
            int row = r+i;
            if(row<0 || row>=board.length)
                continue;
            for(int j=-1;j<2;j++){
               int col = c + j;
               if(i==0 && j==0) continue;
                if(col<0 || col>=board[0].length)
                    continue;
                if(board[row][col]=='M'){
                       count++;   
               }
            }
        }
        if(board[r][c] == 'E'){
            if(count>0){
                board[r][c] = (char) (count+'0');
            }
            else{
                board[r][c]='B';
                for(int i=-1;i<2;i++){
                    int row = r+i;
                    if(row<0 || row>=board.length)
                        continue;
                    for(int j=-1;j<2;j++){
                        int col = c + j;
                        if(i==0 && j==0)    continue;
                        if(col<0 || col>=board[0].length)
                            continue;
                        dfs(board,row,col);
                    }
                }
            }
        }
    }
}
