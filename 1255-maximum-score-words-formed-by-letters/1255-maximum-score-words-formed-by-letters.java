class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for (char c : letters) {
            freq[c - 'a']++;
        }

        return backtrack(words, freq, score, 0);
    }

    private int backtrack(String[] words, int[] freq, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        int skip = backtrack(words, freq, score, index + 1);

        int wordScore = 0;
        int[] used = new int[26];
        boolean possible = true;

        for (char c : words[index].toCharArray()) {
            int i = c - 'a';
            used[i]++;
            if (used[i] > freq[i]) {
                possible = false;
            }
            wordScore += score[i];
        }

        int take = 0;

        if (possible) {
            for (int i = 0; i < 26; i++) {
                freq[i] -= used[i];
            }

            take = wordScore + backtrack(words, freq, score, index + 1);

            for (int i = 0; i < 26; i++) {
                freq[i] += used[i];
            }
        }

        return Math.max(skip, take);
    }
}