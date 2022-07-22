package SDE.Matrix;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] ans = new int[rows*cols][2];
        
        ans[0]=new int[]{rStart,cStart};
        
        int tr = rStart-1;
        int br = rStart+1;
        int lc= cStart-1;
        int rc = cStart+1;
        
        int k=1;
        
        while(tr>=0 || br<rows || lc>=0 || rc<cols){
            
            //right col
            if(rc<cols)
                for(int r=tr+1;r<=br;r++){
                    if(r>=0 && r<rows)
                        ans[k++]=new int[]{r,rc};
                }
            
            //bottom row
            if(br<rows)
                for(int c=rc-1;c>=lc;c--){
                    if(c>=0 && c<cols)
                        ans[k++]=new int[]{br,c};
                }
            
            //left column
            if(lc>=0)
                for(int r=br-1;r>=tr;r--){
                    if(r>=0 && r<rows)
                        ans[k++]=new int[]{r,lc};
                }
            
            //top row
            if(tr>=0)
                for(int c=lc+1;c<=rc;c++){
                    if(c>=0 && c<cols)
                        ans[k++]=new int[]{tr,c};
                }
            

            
            tr=tr-1;
            br=br+1;
            lc=lc-1;
            rc=rc+1;
        }
        
        return ans;
    }
}
