import java.util.Arrays;

public class SolutionNaive {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;

        int candySum = 0;
        int lastMax = 0;

        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] == ratings[i - 1]) {
                candies[i] = 1;
                lastMax = i;
                continue;
            } else if (ratings[i] < ratings[i - 1]) {
                candies[i] = candies[i - 1] - 1;
                if (candies[i] <= 0) {
                    for (int j = lastMax; j <= i; j++) {
                        ++candies[j];
                    }
                }
            } else {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            candySum += candies[i];
        }

        return candySum;
    }
}