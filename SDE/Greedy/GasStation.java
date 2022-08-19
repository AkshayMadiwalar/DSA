package SDE.Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total = 0;
        
        for(int i=0;i<gas.length;i++)
            total+=gas[i]-cost[i];
        
        if(total<0)
            return -1;
        
        int accumulate = 0;
        int index = 0;
        
        for(int i=0;i<gas.length;i++){
            int cur_gain = gas[i]-cost[i];
            if(accumulate+cur_gain < 0){
                accumulate = 0;
                index = i+1;
            }
            else{
                accumulate+=cur_gain;
            }
        }
        
        return index;
    }
}
