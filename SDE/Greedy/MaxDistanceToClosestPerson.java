class Solution {
    public int maxDistToClosest(int[] seats) {

     int[] ps = new int[seats.length];
     int[] ss = new int[seats.length];

     for(int i=0;i<seats.length;i++){
         if(seats[i]==1)
            continue;
        else{
            if(i>0)
                ps[i]=ps[i-1]+1;
        }
     }

    for(int i=seats.length-1;i>=0;i--){
         if(seats[i]==1)
            continue;
        else{
            if(i<seats.length-1)
                ss[i]=ss[i+1]+1;
        }
     }

    int max = Integer.MIN_VALUE;

     for(int i=0;i<ps.length;i++){
        int dist = Math.min(ps[i],ss[i]);
         max=Math.max(max,dist);
     }



     //corner cases

       int first = Math.max(ps[0],ss[0]);
        int last = Math.max(ps[seats.length-1],ss[seats.length-1]);
        int temp = Math.max(first, last);
        max = Math.max(max,temp);

     return max;

    }
}
