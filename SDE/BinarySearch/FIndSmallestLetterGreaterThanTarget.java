package SDE.BinarySearch;

public class FIndSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int l = 0;
        int h = letters.length-1;
        
        while(l<h){
            int mid = l+(h-l)/2;
            if(target-'a'<letters[mid]-'a')
                h=mid;
            else if(target-'a'>=letters[mid]-'a')
                l=mid+1;
        }
        
        if(l==h && target-'a' >= letters[h]-'a')
            return letters[0];
        
        return letters[h];
    }
}
