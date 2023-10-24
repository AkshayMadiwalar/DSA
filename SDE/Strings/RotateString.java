    public boolean rotateString(String s, String goal) {
        s=s+s;
        return (s.length()/2)==goal.length() && s.contains(goal);
        
    }