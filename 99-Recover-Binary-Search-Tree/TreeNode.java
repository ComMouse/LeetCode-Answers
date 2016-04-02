import java.util.ArrayDeque;

/**
 * TreeNode
 * Simple LeetCode Binary Tree implementation.
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x)
    {
        val = x;
    }

    public void print()
    {
        System.out.print(val + ",");
        if (left != null) {
            left.print();
        } else {
            System.out.print("#,");
        }
        if (right != null) {
            right.print();
        } else {
            System.out.print("#,");
        }
    }
    
    public static TreeNode createTree(String tree)
    {
        String[] nodes = tree.split(",");
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        
        TreeNode rootNode = new TreeNode(Integer.parseInt(nodes[0]));
        queue.push(rootNode);
        
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode parent = queue.remove();
            if (!nodes[i].equals("#")) {
                int lval = Integer.parseInt(nodes[i]);
                TreeNode left = new TreeNode(lval);
                parent.left = left;
                queue.add(left);
            }
            
            if (i + 1 < nodes.length && !nodes[i + 1].equals("#")) {
                int rval = Integer.parseInt(nodes[i + 1]);
                TreeNode right = new TreeNode(rval);
                parent.right = right;
                queue.add(right);
            }
        }
        
        return rootNode;
    }
}