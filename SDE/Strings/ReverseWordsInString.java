package SDE.Strings;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String newstr = "";
        int j=s.length()-1;
        int i=s.length()-1;
        
        String ts = "";
        int first = 0;
        
        while(i>=0){
            if(j==-1){
                break;
            }
            if(s.charAt(j)!=' '){
                j--;
            }
            else if(s.charAt(j)==' ' && i==j){
                j--;
                i=j;
            }
            else{
                if(first==1)
                    newstr+=" ";
                newstr+=s.substring(j+1,i+1);
                first=1;
                j--;
                i=j;
            }
        }
        if(j!=i){
            if(i!=s.length()-1) newstr+=" ";
            newstr+=s.substring(j+1,i+1);
        }
       
        return newstr;
    }
}
