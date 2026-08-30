/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal, 0);
    }

    private TreeNode build(String s, int depth) {
        int temp = index;
        int dashes = 0;

        while (temp < s.length() && s.charAt(temp) == '-') {
            dashes++;
            temp++;
        }

        if (dashes != depth) {
            return null;
        }

        index = temp;

        int num = 0;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(num);

        node.left = build(s, depth + 1);
        node.right = build(s, depth + 1);

        return node;
    }
}