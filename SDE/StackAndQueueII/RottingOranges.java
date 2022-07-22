package SDE.StackAndQueueII;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Pair{
        int x;int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    class Solution {
        public int orangesRotting(int[][] grid) {
            
            Queue<Pair> q = new LinkedList<>();
            int m=grid.length;
            int n=grid[0].length;
            int minutes = 0;
            int total_orange=0;
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==2){
                        q.add(new Pair(i,j));
                    }
                    if(grid[i][j]!=0){
                        total_orange++;
                    }
                }
            }
            
            int org=0;
                
            while(q.size()>0){
                int size=q.size();
                org+=size;
                while(size>0){
                    Pair pair = q.poll();
                    int i=pair.x;
                    int j=pair.y;
                    //up
                  
                    if(i>0)
                        if(grid[i-1][j]==1){
                            q.add(new Pair(i-1,j));
                            grid[i-1][j]=2;
                        }
                    //down
                    if(i<m-1)
                        if(grid[i+1][j]==1){
                            q.add(new Pair(i+1,j));
                            grid[i+1][j]=2;
                        }
                    //left
                    if(j>0)
                        if(grid[i][j-1]==1){
                            q.add(new Pair(i,j-1));
                            grid[i][j-1]=2;
                        }
                    //right
                    if(j<n-1)
                        if(grid[i][j+1]==1){
                            q.add(new Pair(i,j+1));
                            grid[i][j+1]=2;
                        }
                    
                    
                    size--;
                }
                if(q.size()>0) minutes++;
            }
            
            return total_orange==org?minutes:-1;
        }
    }
}
