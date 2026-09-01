class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, ans);
        return ans;
    }

    private void generate(String s, int n, List<String> ans) {
        if (s.length() == n) {
            ans.add(s);
            return;
        }

        generate(s + "1", n, ans);

        if (s.length() == 0 || s.charAt(s.length() - 1) != '0') {
            generate(s + "0", n, ans);
        }
    }
}