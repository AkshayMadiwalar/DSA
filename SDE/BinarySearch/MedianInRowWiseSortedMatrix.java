package SDE.BinarySearch;

public class MedianInRowWiseSortedMatrix {
    int median(int matrix[][], int r, int c) {
        // code here      
        int min = matrix[0][0];
        int max = matrix[0][c-1];
        for(int i=0;i<matrix.length;i++){
            min = Math.min(min,matrix[i][0]);
            max = Math.max(max,matrix[i][c-1]);
        }
        
        int pos = (r*c+1)/2;
        while(min<max){
            int mid = min+(max-min)/2;
            
            int no_elements_small = count(matrix,mid);
            
            if(no_elements_small<pos){
                min = mid+1;
            }
            else
                max = mid;
            
        }
        return min;
    }
    
    int count(int matrix[][], int ele){
        int c = 0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]<=ele){
                for(int j=0;j<matrix[i].length;j++){
                    if(matrix[i][j]<=ele)
                        c++;
                }
            }
        }
        return c;
    }
}
