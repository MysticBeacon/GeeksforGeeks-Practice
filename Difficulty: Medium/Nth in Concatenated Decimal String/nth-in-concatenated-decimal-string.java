
class Solution {
    public char nthCharacter(int n) {
        long digits = 1;
        long count = 9;
        long start = 1;

        // Find the group containing the nth character
        while (n > digits * count) {
            n -= (int) (digits * count);
            digits++;
            count *= 10;
            start *= 10;
        }

        // Find the number containing the character
        long number = start + (n - 1) / digits;

        // Find the character's position within the number
        int index = (int) ((n - 1) % digits);

        return Long.toString(number).charAt(index);
    }
}
