class Solution {
    public String lexiString(String s) {
        int n = s.length();
        String ss = s + s;

        int i = 0;
        int j = 1;
        int k = 0;

        while (i < n && j < n && k < n) {
            char a = ss.charAt(i + k);
            char b = ss.charAt(j + k);

            if (a == b) {
                k++;
            } 
            else if (a > b) {
                i = i + k + 1;

                if (i <= j) {
                    i = j + 1;
                }

                k = 0;
            } 
            else {
                j = j + k + 1;

                if (j <= i) {
                    j = i + 1;
                }

                k = 0;
            }
        }

        int start = Math.min(i, j);

        return ss.substring(start, start + n);
    }
}