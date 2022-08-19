package Graphs;

import java.util.*;

public class CheapestFlightsWithKStops {
    class Flight{
        int place;
        int stops;
        int price;
        Flight(int price,int place, int stops){
            this.place=place;
            this.stops=stops;
            this.price=price;
        }
    }
    
    class Solution {
        int cheapest = Integer.MAX_VALUE;
        
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            
            for(int i=0;i<n;i++)
                adj.add(new ArrayList<>());
            
            for(int i=0;i<flights.length;i++){
                adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
            }
            int[] visited = new int[n];
            // dfs(adj,src,dst,k+1,0,visited);
            // return cheapest==Integer.MAX_VALUE?-1:cheapest;
            
            return flights(adj,src,dst,k);
        }
        
        
        public int flights(List<List<int[]>> adj, int src, int dst, int k){
            PriorityQueue<Flight> pq = new PriorityQueue<Flight>((a,b)->a.price-b.price);
            pq.add(new Flight(0,src,k+1));
            
            while(pq.size()>0){
                Flight flight = pq.poll();
                
                if(flight.place == dst)
                    return flight.price;
                
                int curr_price = flight.price;
                int stops = flight.stops;
                
                if(stops>0){
                    for(int[] each: adj.get(flight.place)){
                        pq.add(new Flight(curr_price+each[1],each[0],stops-1));
                    }
                }
            }
            
            return -1;
            
        }
        
        
        // Recursion DFS -- TLE
        
    //     public void dfs(List<List<int[]>> adj, int node, int dst, int k,int price,int[] visited){
    //         if(k<0)
    //             return;
    //         if(node==dst){
    //             //compute answer
    //             cheapest=Math.min(cheapest,price);
    //             return;
    //         }
            
    //         for(int[] each: adj.get(node)){
    //             if(visited[each[0]]==0){
    //                 int p = each[1];
    //                 visited[each[0]]=1;
    //                 dfs(adj,each[0],dst,k-1,price+p,visited);
    //                 visited[each[0]]=0;
    //             }
    //         }
    //     }
    }
}
