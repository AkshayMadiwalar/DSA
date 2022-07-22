package SDE.RecursionAndBacktracking;

public class MColouring {
    

    public boolean isSafe(boolean graph[][], int node, int m, int[] color){
        
        for(int i=0;i<graph.length;i++){
            if(graph[node][i]==true && color[i]==m)    
                return false;
        }
        return true;
    }
    
    public boolean mcolor(boolean graph[][], int node, int m, int n, int[] color){
        
        if(node == n)
            return true;
            
        for(int i=1;i<=m;i++){
            if(isSafe(graph,node,i,color)){
                color[node]=i;
                if(mcolor(graph,node+1,m,n,color)==true)
                    return true;
                else
                    color[node]=-1;
            }
        }
        
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n];
        for(int i=0;i<color.length;i++)
            color[i]=-1;
        return mcolor(graph,0,m,n,color);
    }
}
