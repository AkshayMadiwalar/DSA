class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        return solve(s1,s2,map);
    }

    public boolean solve(String s1, String s2, HashMap map){

        if(s1.equals(s2))
            return true;

        if(s1.length()==1){
            return s1.equals(s2);
        }

        if(map.containsKey(s1+s2)){
            return map.get(s1+s2).equals(1)?true:false;
        }

        int n = s1.length();
        for(int i=1;i<n;i++){

            //swaped
            boolean swapped  =false;
            if(solve(s1.substring(0,i),s2.substring(n-i),map) && solve(s1.substring(i), s2.substring(0,n-i),map))
                swapped = true;

            boolean not_swapped = false;
            if(solve(s1.substring(0,i),s2.substring(0,i),map) && solve(s1.substring(i), s2.substring(i),map))
                not_swapped = true;

            if(swapped || not_swapped){
                map.put(s1+s2,1);
                return true;
            }
        }
        
        map.put(s1+s2,0);
        return false;
    }
}

