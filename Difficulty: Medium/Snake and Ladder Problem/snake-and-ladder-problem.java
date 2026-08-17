 class Solution {
     public int minThrows(int n, int[] lad, int[] sn) {
         int target = n * n;
         int[] moves = new int[target + 1];
         for (int i = 0; i <= target; i++) {
             moves[i] = i;
         }
         for (int i = 0; i < lad.length; i += 2) {
             moves[lad[i]] = lad[i + 1];
         }
         for (int i = 0; i < sn.length; i += 2) {
             moves[sn[i]] = sn[i + 1];
         }

         Queue<Integer> queue = new LinkedList<>();
         boolean[] visited = new boolean[target + 1];

         queue.add(1);
         visited[1] = true;
         int throwsCount = 0;

         while (!queue.isEmpty()) {
             int size = queue.size();

             for (int i = 0; i < size; i++) {
                 int curr = queue.poll();

                 if (curr == target) {
                     return throwsCount;
                 }

                 // Try all 6 dice choices
                 for (int dice = 1; dice <= 6; dice++) {
                     int next = curr + dice;

                     if (next <= target) {
                         int destination = moves[next];

                         if (!visited[destination]) {
                             visited[destination] = true;
                             queue.add(destination);
                         }
                     }
                 }
             }
             throwsCount++;
         }

         return -1;
     }
 }