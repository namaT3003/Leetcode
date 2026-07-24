class Solution {
    public int maxDistinct(String s) {
         int[] freq = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == 0) {
                count++;
                freq[index] = 1;
            }
        }

        return count;
    }
}