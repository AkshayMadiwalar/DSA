 public int beautySum(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int beauty = 0;

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),1);
            for(int j=i+1;j<s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.size()>=2){
                    beauty = beauty + getBeauty(map);
                }
            }
            map.clear();
        }
        return beauty;
    }

    public int getBeauty(HashMap<Character,Integer> map){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            min=Math.min(min,entry.getValue());
            max=Math.max(max,entry.getValue());
        }
        return max-min;
    }