package SDE.StringsII;

import java.util.ArrayList;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        
        for(int i=0;i<numRows;i++)
            grid.add(new ArrayList<>());
        
        int ind = 0;
        int j=0;
        while(true){
            if(ind==0){
                while(ind<numRows){
                    grid.get(ind).add(s.charAt(j));
                    j++;
                    ind++;
                    if(j>=s.length())
                        break;
                }
                ind=ind-2<=-1?0:ind-2;
            }
            else if(ind>0){
                grid.get(ind).add(s.charAt(j));
                ind--;
                j++;
            }
            if(j>=s.length())
                break;
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<grid.size();i++)
            for(int k=0;k<grid.get(i).size();k++){
                ans.append(grid.get(i).get(k));
            }
        
        return ans.toString();
    }
}
