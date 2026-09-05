class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;

        for (String sentence : sentences) {
            int words = sentence.split(" ").length;
            ans = Math.max(ans, words);
        }

        return ans;
    }
}