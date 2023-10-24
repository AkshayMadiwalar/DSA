public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n =nums1.length+nums2.length;
        
        int i2 = n/2 ;
        int i1 = i2 -1;

       int i = 0;
       int j = 0;

        int count = 0;
        int ele1=0;
        int ele2=0;
       while(i<nums1.length && j<nums2.length){
        
            if(nums1[i]<nums2[j]){
                if(count == i1)
                    ele1 = nums1[i];
                if(count == i2)
                    ele2 = nums1[i];
                i++;
            }
            else{
                if(count == i1)
                    ele1 = nums2[j];
                if(count == i2)
                    ele2 = nums2[j];
                j++;
            }

            count++;
       }

       while(i<nums1.length){
                if(count == i1)
                    ele1 = nums1[i];
                if(count == i2)
                    ele2 = nums1[i];
                i++;
                count++;
       }

       while(j<nums2.length){
                if(count == i1)
                    ele1 = nums2[j];
                if(count == i2)
                    ele2 = nums2[j];
                j++;
                count++;
       }

        if(n%2 == 1)
            return ele2;

       return (double)(ele1+ele2)/2.0;
    }