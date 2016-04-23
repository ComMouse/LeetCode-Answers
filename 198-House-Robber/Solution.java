public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int num = nums.length;
        
        int money_skipped_last_house = 0;
        int money_visited_last_house = nums[0];
        
        for (int i = 1; i < num; ++i) {
            int money_new = money_skipped_last_house + nums[i];
            if (money_visited_last_house > money_skipped_last_house) {
                money_skipped_last_house = money_visited_last_house;
            }
            money_visited_last_house = money_new;
        }
        
        return Math.max(money_skipped_last_house, money_visited_last_house);
        
        // Old version
        // for (int i = 1; i < num; ++i) {
        //     money[i][0] = money[i - 1][0] > money[i - 1][1] ? money[i - 1][0] : money[i - 1][1];
        //     money[i][1] = money[i - 1][0] + nums[i];
        // }
        //return Math.max(money[num - 1][0], money[num - 1][1]);
    }
}