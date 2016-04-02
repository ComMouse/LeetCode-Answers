/**
 * Main Test Cases.
 */
public class Test
{
    public static void main(String[] args)
    {
        test("2,3,1");
        test("2,1,5,#,#,4,#,#,3");
        test("0,1");
        test("2,#,3,1");
    }
    
    public static void test(String testCase)
    {
        TreeNode root = TreeNode.createTree(testCase);
        (new Solution()).recoverTree(root);
        if (!dfsCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Test case failed: " + testCase);
        }
        // root.print();
        // System.out.println();
    }
    
    public static boolean dfsCheck(TreeNode node, int min, int max)
    {
        if (node == null) {
            return true;
        }
        
        if ((node.left != null && (node.val < node.left.val || node.left.val < min || node.left.val > max)) ||
            (node.right != null && (node.val > node.right.val || node.right.val < min || node.right.val > max))
        ) {
            return false;
        }
        
        return dfsCheck(node.left, min, Integer.min(node.val, max)) &&
            dfsCheck(node.right, Integer.max(min, node.val), max);
    }
}