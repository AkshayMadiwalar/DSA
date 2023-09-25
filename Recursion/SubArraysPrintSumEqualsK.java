public class SubArraysPrintSumEqualsK {

    
    public static void subArrWithSumKOptimal(int[] arr, int n, int k) {
        int start = 0, end = -1, sum = 0;
        while (start < n) {
          while ((end + 1 < n) && (sum + arr[end + 1] <= k))
            sum += arr[++end];
    
          if (sum == k) {
            for (int p = start; p <= end; p++)
              System.out.print(arr[p] + " ");
            System.out.println();
          }
    
          sum -= arr[start];
          start++;
        }
      }
}