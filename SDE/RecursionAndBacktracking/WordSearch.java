package SDE.RecursionAndBacktracking;

public class WordSearch {
    public boolean dfs(int i, int j,char[][] board,String word,int[][] visited,int path){
        
        if(i<0 || i>= board.length || j<0 || j>=board[0].length)
            return false;
        
        if(path == word.length()){
            return true;
        }
        
        if(word.charAt(path)!=board[i][j]){
            return false;
        }else{
            if(path==word.length()-1)
                return true;
        }
    
        
        if(i<board.length-1 && visited[i+1][j]!=1){
            visited[i][j]=1;
            if(dfs(i+1,j,board,word,visited,path+1))
                return true;
            else{
                visited[i][j]=0;
            }
        }
        
        if(j<board[0].length-1 && visited[i][j+1]!=1){
            visited[i][j]=1;
            if(dfs(i,j+1,board,word,visited,path+1))
                return true;
            else{
                visited[i][j]=0;
            }
        }
        
        if(j>0 && visited[i][j-1]!=1){
            visited[i][j]=1;
            if(dfs(i,j-1,board,word,visited,path+1))
                return true;
            else{
                 visited[i][j]=0;
            }
        }
        
        if(i>0 && visited[i-1][j]!=1){
            visited[i][j]=1;
            if(dfs(i-1,j,board,word,visited,path+1))
                return true;
            else{
                visited[i][j]=0;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        int x=0;
        int y=0;
        boolean ans=false;
        
        if(board.length==1 && board[0].length==1){
            if(word.length()>1)   return false;
            return board[0][0]==word.charAt(0)?true:false;
        }
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    x=i;
                    y=j;
                    ans = ans || dfs(x,y,board,word,visited,0);
                }
            }
        }
        return ans;
    }
}
