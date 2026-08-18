class Solution {
    public String compress(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            if ((i + 1) % 2 == 0) {
                int half = (i + 1) / 2;
                int len = lps[i];
                while (len > half) {
                    len = lps[len - 1];
                }

                if (len == half) {
                    sb.append('*');
                    i = half - 1;
                    continue;
                }
            }

            sb.append(s.charAt(i));
            i--;
        }

        return sb.reverse().toString();
    }
}