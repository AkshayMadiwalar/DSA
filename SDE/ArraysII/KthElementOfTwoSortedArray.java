public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int size = n + m;
        
        int count = 0;

        int i = 0;
        int j = 0;

        int ele = 0;
        k=k-1;

       while(i<n && j<m){
        
            if(arr1.get(i)<arr2.get(j)){
                if(count == k)
                    ele = arr1.get(i);
                i++;
            }
            else{
                if(count == k)
                    ele = arr2.get(j);
                j++;
            }

            count++;
       }

       while(i<n){
                if(count == k)
                    ele = arr1.get(i);
                i++;
                count++;
       }

       while(j<m){
                if(count == k)
                    ele = arr2.get(j);
                j++;
                count++;
       }

        return ele;
  
    }