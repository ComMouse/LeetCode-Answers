public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
             
        int[] list = new int[n + 1];
        list[1] = 1;
         
        int index_2 = 1;
        int index_3 = 1;
        int index_5 = 1;
        for (int i = 2; i <= n; ++i) {
            list[i] = Math.min(list[index_2] * 2, Math.min(list[index_3] * 3, list[index_5] * 5));
             
            if (list[i] == list[index_2] * 2)
                ++index_2;
            if (list[i] == list[index_3] * 3)
                ++index_3;
            if (list[i] == list[index_5] * 5)
                ++index_5;
        }
         
        return list[n];
    }
}