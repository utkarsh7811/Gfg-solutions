
class Solution {
     public int minProd(int[] arr) {
         int n = arr.length;

         if (n == 1) {
             return arr[0];
         }

         int maxNeg = Integer.MIN_VALUE;
         int minPos = Integer.MAX_VALUE;
         int countNeg = 0;
         int countZero = 0;
         int prod = 1;

         for (int i = 0; i < n; i++) {
             int val = arr[i];

             if (val == 0) {
                 countZero++;
                 continue;
             }

             if (val < 0) {
                 countNeg++;
                 maxNeg = Math.max(maxNeg, val);
             } else {
                 minPos = Math.min(minPos, val);
             }

             prod *= val;
         }
         if (countZero == n) {
             return 0;
         }
         if (countNeg == 0) {
             return countZero > 0 ? 0 : minPos;
         }
         if (countNeg % 2 == 0) {
             prod /= maxNeg;
         }

         return prod;
     }
 }