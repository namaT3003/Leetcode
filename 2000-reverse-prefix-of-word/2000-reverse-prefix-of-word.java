class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = index; i >= 0; i--) {
            ans.append(word.charAt(i));
        }

        for (int i = index + 1; i < word.length(); i++) {
            ans.append(word.charAt(i));
        }

        return ans.toString();
    }
}