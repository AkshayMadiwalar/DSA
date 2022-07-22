package DP.JumpGame;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        return jump(start,arr,visited);
    }
    
    public boolean jump(int ind,int[] arr,int[] visited){
        if(arr[ind]==0)
            return true;
        
        visited[ind]=1;
        
        if(ind+arr[ind]<arr.length && visited[ind+arr[ind]]==0 && jump(ind+arr[ind],arr,visited))
            return true;
        
        if(ind-arr[ind]>=0 && visited[ind-arr[ind]]==0 && jump(ind-arr[ind],arr,visited))
            return true;
        
        return false;
    }
}
