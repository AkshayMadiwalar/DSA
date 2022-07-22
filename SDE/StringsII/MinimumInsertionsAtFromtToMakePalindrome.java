package SDE.StringsII;

public class MinimumInsertionsAtFromtToMakePalindrome {
    public static int minChar(String str) {
        //Write your code here
        int i=0;
        int j=str.length()-1;
        int c=0;
        
        while(i<str.length() && j>=0){
            if(str.charAt(i)==str.charAt(j) && isPalindrome(str,i+1,j-1)){
                break;
            }else{
                c++;
                str=str.substring(0,str.length()-1);
                i=0;
                j=str.length()-1;
            }
        }
        
        return c;
        
     }
     
     public static boolean isPalindrome(String str,int i, int j){
         if(i>=j)
             return true;
         if(str.charAt(i)!=str.charAt(j))
             return false;
         if(str.charAt(i)==str.charAt(j) && isPalindrome(str,i+1,j-1))
             return true;
         return false;
     }
}
