public class FindAllAnagramsInOtherString {

    
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int count =0;
        
        for(int i=0;i<p.length();i++){
            if(!map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i),1);
                count=count+1;
            }else{
                int c = map.get(p.charAt(i))+1;
                map.put(p.charAt(i),c);
            }
        }
        
        int start=0;
        int end=0;
        
        List<Integer> ans = new ArrayList<>();
        
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                int c=map.get(s.charAt(end))-1;
                map.put(s.charAt(end),c);
                if(c == 0){
                    count--;
                }
            }
            
            if(end-start+1 < p.length())
                end++;
            else if(end-start+1 == p.length()){
                if(count == 0){
                    ans.add(start);

                }
                    if(map.containsKey(s.charAt(start))){
                        int c=map.get(s.charAt(start))+1;
                        map.put(s.charAt(start),c);
                        if(c==1) count++;
                    }
                start++;
                end++;
            }
        }
        
        return ans;
    }
}
