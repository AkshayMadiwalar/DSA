package Graphs;

import java.util.*;

public class PacificToAltlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      
        List<List<Integer>> ans = new ArrayList<>();
   
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                
                boolean   a = false;
                
                if(atlantic[i][j]==1)
                    a=true;
                else
                    a = toA(i,j,heights,visited,atlantic);
                
                visited = new boolean[heights.length][heights[0].length];
                
                boolean p = false;
                
                if(pacific[i][j]==1)
                    p=true;
                else
                    p=toP(i,j,heights,visited,pacific);
                
                if( a && p){
                    List<Integer> r= new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    ans.add(r);
                }
                    
                
            }
        }
        return ans;
    }
    
    public boolean toA(int i, int j,int[][] heights, boolean[][] visited,int[][] atlantic){
        
        visited[i][j] = true;
        
        if(i>=heights.length || j>=heights[0].length)
            return true;
        
        //right
        if(j+1 >= heights[0].length || (visited[i][j+1]==false && heights[i][j]>=heights[i][j+1] && toA(i,j+1,heights,visited,atlantic))){
            atlantic[i][j]=1;
            return true;
        }
         
        
                //down
        if(i+1 >= heights.length || (visited[i+1][j]==false && heights[i][j]>=heights[i+1][j] && toA(i+1,j,heights,visited,atlantic))){
            atlantic[i][j]=1;
            return true;
        }
        
        //up
        if(i-1>=0)
            if(visited[i-1][j]==false && heights[i][j]>=heights[i-1][j] && toA(i-1,j,heights,visited,atlantic)){
                atlantic[i][j]=1;
                return true;
            }
        
        //left
        if(j-1>=0)
            if(visited[i][j-1]==false && heights[i][j]>=heights[i][j-1] && toA(i,j-1,heights,visited,atlantic)){
                atlantic[i][j]=1;
                return true;
            }
        
        return false;
    }
    
    public boolean toP(int i, int j, int[][] heights, boolean[][] visited,int[][] pacific){
        
        visited[i][j]=true;
        
        if(i<0 || j<0)
            return true;
        
        //up
        if(i-1<0 || (visited[i-1][j]==false && heights[i][j]>=heights[i-1][j] && toP(i-1,j,heights,visited,pacific)==true)){
            pacific[i][j]=1;
            return true;
        }
        
        //left
        if(j-1<0 || (visited[i][j-1]==false && heights[i][j]>=heights[i][j-1] && toP(i,j-1,heights,visited,pacific)==true)){
         pacific[i][j]=1;
            return true;
        }
        
        //right
        if(j+1<heights[0].length)
            if(visited[i][j+1]==false && heights[i][j]>=heights[i][j+1] && toP(i,j+1,heights,visited,pacific)==true){
             pacific[i][j]=1;
                return true;
            }
        
        //down
        if(i+1<heights.length)
            if(visited[i+1][j]==false && heights[i][j]>=heights[i+1][j] && toP(i+1,j,heights,visited,pacific)==true){
             pacific[i][j]=1;
                return true; 
            }
        
        return false;
    }
    
    
}
