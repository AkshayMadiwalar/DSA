package SDE.ArraysII;

import java.util.*;

public class RandomizedSet {
     
    HashMap<Integer,Integer> map;
    Random random;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int ind = map.get(val);
        int lastind = list.size()-1;
        list.set(ind,list.get(lastind));
        map.put(list.get(lastind),ind);
        list.remove(lastind);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
