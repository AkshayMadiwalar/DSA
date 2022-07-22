package SDE.Strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            prefix = prefixutil(prefix,strs[i]);
        }
        return prefix;
    }
    
    public String prefixutil(String str1,String str2){
        if(str1.length()==0 || str2.length()==0)
            return "";
        int i=0;
        int j=0;
        
        String res = "";
        
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)!=str2.charAt(j))
                break;
            res+=str1.charAt(i);
            i++;
            j++;
        }
        return res;
    }
}
