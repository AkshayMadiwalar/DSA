package SDE.StringsII;

import java.util.Arrays;
import java.util.HashMap;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>();
        String ans = "";
        int max = 0;
        String[] p = paragraph.split("[ !?',;.]+");
        for(String word: p){
            if(word.length()==0)
                continue;
            word = word.toLowerCase();
            if(!map.containsKey(word))
                map.put(word,1);
            else
                map.put(word,map.get(word)+1);
            if(max<map.get(word)){
                if(Arrays.asList(banned).indexOf(word)==-1){
                    ans = word;
                    max =map.get(word);
                }
            }
        }
        return ans;
    }
}
