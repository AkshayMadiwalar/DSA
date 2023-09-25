package SDE.Strings;

public class RemoveOuterMostParathesis {
    public String removeOuterParentheses(String s) {
        
        int open = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(open>0){
                    sb.append(ch);
                }
                open++;
            }
            else{
                if(open>1){
                    sb.append(ch);
                }
                open--;
            }
        }
        
        return sb.toString();
    }
}
