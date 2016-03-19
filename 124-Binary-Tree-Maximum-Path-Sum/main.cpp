/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
	int maxPathSum(TreeNode* root) {
		if (root == NULL)
			return 0;
		maxSum = INT_MIN;
		calcPathSum(root, singlePathMaxSum(root->left), singlePathMaxSum(root->right));
		return maxSum;
	}
private:
	// record the current max sum
	int maxSum;

	// calc current path and update maxSum
	void calcPathSum(TreeNode* root, int leftMaxSum, int rightMaxSum) {
		// find the maximum current sum
		int tempMaxSum = max(root->val,
			max(root->val + leftMaxSum,
			max(root->val + rightMaxSum,
			root->val + leftMaxSum + rightMaxSum)));

		// update maxSum
		maxSum = max(tempMaxSum, maxSum);
	}

	int singlePathMaxSum(TreeNode* root) {
		if (root == NULL)
			return 0;

		// recurve to get left and right path sum
		int left = singlePathMaxSum(root->left);
		int right = singlePathMaxSum(root->right);
		// calc the current path sum
		calcPathSum(root, left, right);

		// return maximum path sum
		return max(root->val, max(root->val + left, root->val + right));
	}
};