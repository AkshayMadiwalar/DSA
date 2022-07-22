package SDE.Strings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        String ans = "";

        int[][] dp = new int[s.length()][s.length()];
        
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                
                if(s.charAt(i)==s.charAt(j) && isPalindrome(s,i+1,j-1,dp)){
                    if(max<j-i+1){
                        max=j-i+1;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
    
    public boolean isPalindrome(String s,int i,int j,int[][] dp){
        if(i==j || i>j)
            return true;
        if(s.charAt(i)!=s.charAt(j)){
            dp[i][j]=2;
            return false;
        }
       
        
        if(dp[i][j]!=0){
            return dp[i][j]==1?true:false;
        }
        
        if(s.charAt(i)==s.charAt(j) && isPalindrome(s,i+1,j-1,dp)){
            dp[i][j]=1;
            return true;
        }
          
        dp[i][j]=2;
        return false;
    }
}
