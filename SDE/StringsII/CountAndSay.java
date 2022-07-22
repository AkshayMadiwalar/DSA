package SDE.StringsII;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder str=new StringBuilder("11");
        if(n==1)
            return "1";
        if(n==2)
            return str.toString();
        
        for(int i=2;i<n;i++){
            str=cas(str);
        }
        return str.toString();
    }
    
    public StringBuilder cas(StringBuilder s){
        int count=1;
        char c='0';
        StringBuilder temp = new StringBuilder();
        for(int i=1;i<s.length();i++){
            c=s.charAt(i);
            if(s.charAt(i)!=s.charAt(i-1)){
                temp.append(count);
                temp.append(s.charAt(i-1));
                count=0;
            }
           count++;
        }
        temp.append(count);
        temp.append(c);
        return temp;
    }
}
