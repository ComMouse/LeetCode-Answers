public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int moneySkipped = 0;
        int moneySkippedWithout0 = 0;
        int moneyVisited = nums[0];
        int moneyVisitedWithout0 = 0;
        
        for (int i = 1; i < nums.length; ++i) {
            int oldVisited = moneyVisited;
            moneyVisited = moneySkipped + nums[i];
            moneySkipped = Math.max(oldVisited, moneySkipped);
            
            int oldVisitedWithout0 = moneyVisitedWithout0;
            moneyVisitedWithout0 = moneySkippedWithout0 + nums[i];
            moneySkippedWithout0 = Math.max(oldVisitedWithout0, moneySkippedWithout0);
        }
        
        return Math.max(moneySkipped, moneyVisitedWithout0);
    }
}