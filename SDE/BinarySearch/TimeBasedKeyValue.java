package SDE.BinarySearch;

import java.util.*;

class Time{
    int timestamp;
    String val;
    Time(int t,String v){
        this.timestamp=t;
        this.val = v;
    }
}

public class TimeBasedKeyValue {
    HashMap<String,List<Time>> map;
    
    public TimeBasedKeyValue() {
        map  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Time time = new Time(timestamp,value);
        if(!map.containsKey(key))
            map.put(key,new ArrayList<>());
        map.get(key).add(time);
    }
    
    public String get(String key, int timestamp) {
        List<Time> times = map.getOrDefault(key,new ArrayList<>());
        int l=0;
        int r=times.size()-1;
        String res="";
        
        while(l<=r){
            int mid = (l+r)/2;
            if(times.get(mid).timestamp <= timestamp){
                res = times.get(mid).val;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return res;
    }
}
