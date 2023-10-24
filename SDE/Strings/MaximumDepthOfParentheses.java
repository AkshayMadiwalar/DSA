 public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();

        int depth = 0;
        int ans = 0;

        for(char ch:s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                depth++;
                ans=Math.max(ans,depth);
            }
            else if(ch == ')'){
                stack.pop();
                depth--;
            } 
        }
        return ans;
    }