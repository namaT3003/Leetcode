class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
            }
        }

        return ans.toString();
    }
}