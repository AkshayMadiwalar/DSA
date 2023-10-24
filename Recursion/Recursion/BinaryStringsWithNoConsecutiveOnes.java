public class Solution {

    static List<String> ans = new ArrayList<>();
    public static List< String > generateString(int N) {
        // Write your code here.
        gs(0,N,new StringBuilder());
        return ans;
    }

    public static void gs(int index, int N, StringBuilder sb){
        
        if(index == N){
            ans.add(sb.toString());
            return;
        }

        //add 0
        sb.append('0');
        gs(index+1,N,sb);
        sb.deleteCharAt(sb.length()-1);
        

        // add 1
        if(sb.length() == 0 || sb.length()>0 && sb.charAt(sb.length()-1)!='1'){
            sb.append('1');
            gs(index+1,N,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
