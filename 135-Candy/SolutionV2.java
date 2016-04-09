import java.util.Arrays;

public class SolutionV2 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        int candySum = 0;
        int[] candies = new int[ratings.length];
        
        for (int i = 0; i < ratings.length; ++i) {
            candies[i] = 1;
        }

        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            candySum += candies[i];
        }
        candySum += candies[ratings.length - 1];

        return candySum;
    }
}