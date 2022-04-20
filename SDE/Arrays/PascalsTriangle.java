import java.*;
import java.util.ArrayList;
import java.util.List;
public class PascalsTriangle {
    

    //      1
    //     1 1
    //    1 2 1
    //   1 3 3 1

    //add 1 at start and end of every row
    //add previos rows subsequent numbers in current row
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            if(i==0){
                row.add(1);
            }
            else if(i==1){
                row.add(1);
                row.add(1);
            }
            else{
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        row.add(1);
                    }else{
                        row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                    }
                }
            }
            result.add(row);
        }
        
        return result;
    }
}
