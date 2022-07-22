package SDE.StringsII;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        
        int i=0;
        int j=0;
        
        while(i<version1.length() || j<version2.length()){
            int v1=0;
            int v2=0;
            
            while(i<version1.length() && version1.charAt(i)!='.'){
                v1=10*v1+version1.charAt(i)-'0';
                i++;
            }
            
            while(j<version2.length() && version2.charAt(j)!='.'){
                v2=10*v2+version2.charAt(j)-'0';
                j++;
            }
            
            i++;
            j++;
            
            if(v1>v2)
                return 1;
            if(v2>v1)
                return -1;
        }
        
        return 0;
    }
}
