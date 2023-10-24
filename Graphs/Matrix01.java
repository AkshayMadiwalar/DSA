class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] visited = new int[m][n];

        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(new int[]{i,j},0));
                    visited[i][j] = 1;
                }else{
                    visited[i][j] = 0;
                }
            }
        }

        while(queue.size()>0){
            Pair pair = queue.poll();
            int[]  co = pair.co;
            ans[co[0]][co[1]] = pair.steps;
            int steps = pair.steps;
            int i=co[0];
            int j=co[1];

            //up
            if(i>0 && mat[i-1][j]==1 && visited[i-1][j] == 0){
                visited[i-1][j]=1;
                queue.add(new Pair(new int[]{i-1,j},steps+1));
            }
            //down
            if(i<m-1 && mat[i+1][j]==1 && visited[i+1][j] == 0){
                visited[i+1][j]=1;
                queue.add(new Pair(new int[]{i+1,j},steps+1));
            }

            //left
            if(j>0 && mat[i][j-1]==1 && visited[i][j-1] == 0){
                visited[i][j-1]=1;
                queue.add(new Pair(new int[]{i,j-1},steps+1));
            }

            //right
            if(j<n-1 && mat[i][j+1]==1 && visited[i][j+1] == 0){
                visited[i][j+1]=1;
                queue.add(new Pair(new int[]{i,j+1},steps+1));
            }
        }

        return ans;
    }

   
}

class Pair{
    int[] co;
    int steps;
    Pair(int[] co, int steps){
        this.co=co;
        this.steps=steps;
    }
}