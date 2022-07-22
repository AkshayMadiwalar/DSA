public class LongestSubstringWithKUniqueCharacters {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map= new HashMap<Character,Integer>();
        int start=0;
        int end=0;
        int max=-1;
        
        while(end<s.length()){
            if(!map.containsKey(s.charAt(end)))
                map.put(s.charAt(end),1);
            else{
                int c = map.get(s.charAt(end))+1;
                map.put(s.charAt(end),c);
            }
            
            if(map.size()<k)
                end++;
            else if(map.size()==k){
                max=Math.max(max,end-start+1);
                end++;
            }
            else{
                while(map.size()>k){
                    int c = map.get(s.charAt(start))-1;
                    if(c==0)    map.remove(s.charAt(start));
                    else    map.put(s.charAt(start),c);
                    start++;
                }
                max=Math.max(max,end-start+1);
                end++;
            }
            
        }
        return max;
    }
}
