class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    dist[i][j]=0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<edges.length;i++){
            dist[edges[i][0]][edges[i][1]]=edges[i][2];
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }

        int countCity=n;
        int city = -1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold)
                    count++;
            }
            if(count <=countCity){
                countCity =count;
                city = i;
            }
        }

        return city;
    }
}