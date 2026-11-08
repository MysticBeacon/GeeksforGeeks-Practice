
class Solution {
    public int minTime(int n, int s1, int s2) {

        long total = (long) s1 + s2;

        long x = ((long) n * s2) / total;

        long t1 = Math.max(x * s1, (n - x) * s2);

        long t2 = Math.max((x + 1) * s1,
                           (n - x - 1) * s2);

        return (int) Math.min(t1, t2);
    }
}
