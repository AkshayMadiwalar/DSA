package SDE.StringsII;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return isPalin(i,j-1,s) || isPalin(i+1,j,s);
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalin(int i, int j, String s){
        if(i>=j)
            return true;

        if(s.charAt(i)!=s.charAt(j))
            return false;

        return isPalin(i+1,j-1,s);
    }
}
