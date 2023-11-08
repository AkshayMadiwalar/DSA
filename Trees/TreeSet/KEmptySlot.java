class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        
        TreeSet<Integer> ts = new TreeSet<>();
        int day =1;

        for(int bulb:bulbs){
            ts.add(bulb);

            Integer lower = ts.lower(bulb);
            Integer higher = ts.higher(bulb);

            if(lower!=null && bulb-lower-1==k){
                return day;
            }
            else if(higher!=null && higher-bulb-1==k){
                return day;
            }

            day++;
        }

        return -1;
    }
}