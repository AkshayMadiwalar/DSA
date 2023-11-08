class Solution {
    public int minFlips(String target) {
        
        int s='0';
        int prev = s;
        int c=0;
        for(char ch: target.toCharArray()){
            if(ch!=prev){
                c++;
                prev=ch;
            }
        }
        return c;
    }
}