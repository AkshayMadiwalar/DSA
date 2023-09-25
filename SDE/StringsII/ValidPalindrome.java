package SDE.StringsII;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.trim().length()==0)
            return true;
     if(isPalin(0,s.length()-1,s))
             return true;
         return false;
     }
     
     public boolean isPalin(int i, int j, String s){
         
         while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
             i++;
         
         while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
             j--;
         
         if(i>j)
             return true;
         
         if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
             return false;
         
         if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j)) &&
           isPalin(i+1,j-1,s))
             return true;
         
         return false;
     }
}
