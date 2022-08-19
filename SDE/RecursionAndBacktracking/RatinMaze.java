package SDE.RecursionAndBacktracking;

import java.util.ArrayList;

public class RatinMaze {
    
     
    public static void paths(int[][] m, int n,int i, int j, StringBuilder str, int[][] visited, ArrayList<String> ans){
        if(i==n-1 && j==n-1){
            ans.add(str.toString());
            return;
        }    
        
        //downward
        if(i+1<n && visited[i+1][j]!=1 && m[i+1][j]==1){
            visited[i][j]=1;
            paths(m,n,i+1,j,str.append('D'),visited,ans);
            visited[i][j]=0;
            str.deleteCharAt(str.length()-1);
        }
        
        //left
        if(j-1>=0 && visited[i][j-1]!=1 && m[i][j-1]==1){
            visited[i][j]=1;
            paths(m,n,i,j-1,str.append('L'),visited,ans);
            visited[i][j]=0;
            str.deleteCharAt(str.length()-1);
        }
        
        //right
        if(j+1<n && visited[i][j+1]!=1 && m[i][j+1]==1){
            visited[i][j]=1;
            paths(m,n,i,j+1,str.append('R'),visited,ans);
            visited[i][j]=0;
            str.deleteCharAt(str.length()-1);
        }
        
        //up
        if(i-1>=0 && visited[i-1][j]!=1 && m[i-1][j]==1){
            visited[i][j]=1;
            paths(m,n,i-1,j,str.append('U'),visited,ans);
            visited[i][j]=0;
            str.deleteCharAt(str.length()-1);
        }
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                visited[i][j]=0;
        ArrayList<String> ans= new ArrayList<>();
        StringBuilder str = new StringBuilder("");
        paths(m,n,0,0,str,visited,ans);
        return ans;
    }
}
