package SDE.Greedy;

import java.util.Arrays;

public class JobSequencing {
    
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int max=0;
        for(int i=0;i<n;i++){
            if(max<arr[i].deadline)
                max=arr[i].deadline;
        }
        
        int[] schedule = new int[max+1]; 
        
        for(int i=0;i<=max;i++)
            schedule[i]=-1;
        
        int profit=0;
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(schedule[j]==-1){
                    schedule[j]=i;
                    count++;
                    profit+=arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{count,profit};
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
