package SDE.StackAndQueueII;

public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stk.isEmpty())
                stk.push(ch);
            else{
                if(stk.peek()==ch)
                    stk.pop();
                else
                    stk.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        int i=0;
        int j=ans.length()-1;
        while(i<=j){
            char ch = ans.charAt(i);
            ans.setCharAt(i,ans.charAt(j));
            ans.setCharAt(j,ch);
            i++;
            j--;
        }
        return ans.toString();
    };

}
