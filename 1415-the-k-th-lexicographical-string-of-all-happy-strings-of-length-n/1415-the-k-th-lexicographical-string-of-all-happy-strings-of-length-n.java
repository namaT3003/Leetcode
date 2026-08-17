class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] count = {k};
        
        generate(sb, n, count);
        
        return count[0] == 0 ? sb.toString() : "";
    }

    private boolean generate(StringBuilder sb, int n, int[] count) {
        if (sb.length() == n) {
            count[0]--;
            return count[0] == 0;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                continue;
            }

            sb.append(c);

            if (generate(sb, n, count)) {
                return true;
            }

            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}