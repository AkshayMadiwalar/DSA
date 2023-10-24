 public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int num:nums){
            l=Math.max(l,num);
            h+=num;
        }

        while(l<=h){
            int m = (l+h)/2;
            int subArrays = countSubArrays(nums, m);
            if(subArrays<=k){
                h = m -1;
            }
            else{
                l=m+1;
            }
        }

        return l;
    }

    public int countSubArrays(int[] nums, int k){
        int sum = 0;
        int count = 1;
        for(int num:nums){
            if(sum+num <= k){
                sum+=num;
            }
            else{
                count++;
                sum=num;
            }
        }
        return count;
    }