/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    private TreeNode swapNode1 = null;
    private TreeNode swapNode2 = null;
    private TreeNode prevNode = null;
    
    public void recoverTree(TreeNode root)
    {
        dfs(root);

        if (swapNode1 != null && swapNode2 != null) {
            swap(swapNode1, swapNode2);
        }
    }
    
    private void dfs(TreeNode node)
    {
        if (node == null)
            return;

        // Inorder (Sequential) Traversal
        dfs(node.left);

        // Inversion found
        if (prevNode != null && node.val < prevNode.val) {
            // Swap neighbours
            if (swapNode1 == null) {
                swapNode1 = prevNode;
            }
            swapNode2 = node;
        }

        // Update previous node
        prevNode = node;

        dfs(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2)
    {
        // Swap two elements
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }
}