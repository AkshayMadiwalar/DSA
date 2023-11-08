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


        public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int low = Math.max(0, k-m);
        int high = Math.min(n,k);
        
        int left = k;
        
        while(low<high){
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1<n)  r1 = arr1[mid1];
            if(mid2<m)  r2 = arr2[mid2];
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            if(mid1-1>=0)  l1=arr1[mid1-1];
            if(mid2-1>=0)   l2 =arr2[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if (l1>r2){
                high = mid1-1;
            }
            else{
                low=mid1+1;
            }
            
        }
        
        return 0;
        
    }