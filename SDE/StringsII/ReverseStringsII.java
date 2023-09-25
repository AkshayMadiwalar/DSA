public class ReverseStringsII {
    public String reverseStr(String s, int k) {
        int i=0;
        int j=k-1;
        int w=2*k-1;
StringBuilder sb = new StringBuilder(s);
        while(j<s.length()){
            if(w<s.length()){
                while(i<=j){
                    char c = sb.charAt(i);
                    sb.setCharAt(i,s.charAt(j));
                    sb.setCharAt(j,c);
                    i++;
                    j--;
                }
                i=w+1;
                j=w+k;
                w=w+2*k;
            }
            else{
                 while(i<=j){
                    char c = sb.charAt(i);
                    sb.setCharAt(i,s.charAt(j));
                    sb.setCharAt(j,c);
                    i++;
                    j--;
                }
                i=w+1;
                j=w+k;
                w=w+2*k;
            }
        }

        if(j>=sb.length()){
                 j = sb.length()-1;
                 while(i<=j){
                    char c = sb.charAt(i);
                    sb.setCharAt(i,s.charAt(j));
                    sb.setCharAt(j,c);
                    i++;
                    j--;
                }
        }

        return sb.toString();
    }
}
