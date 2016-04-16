public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int maxSum = Integer.MIN_VALUE;     // For negative integer cases
        int currentSum = 0;                 // No number added
        
        for (int i = 0; i < nums.length; ++i) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            // Clear current sequence if the sum becomes negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
}