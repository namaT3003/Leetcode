class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }

        int score = 0;

        for (int i = 0; i < 10; i++) {
            score += freq[i] * i;
        }

        return score;
    }
}