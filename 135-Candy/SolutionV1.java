import java.util.Arrays;

public class SolutionV1 {
    private int[] ratings;
    private int[] candies;
    private boolean[] solved;

    public int find_candy_dp(int index) {
        if (this.solved[index]) {
            return this.candies[index];
        }
        int left = 0;
        int right = 0;

        if (index > 0 && ratings[index - 1] < ratings[index]) {
            left = find_candy_dp(index - 1);
        }
        if (index < ratings.length - 1 && ratings[index] > ratings[index + 1]) {
            right = find_candy_dp(index + 1);
        }

        this.solved[index] = true;
        return (this.candies[index] = Math.max(left, right) + 1);
    }

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        int candySum = 0;
        this.ratings = ratings;
        this.candies = new int[ratings.length];
        this.solved = new boolean[ratings.length];

        for (int i = 0; i < ratings.length; ++i) {
            this.solved[i] = false;
            this.candies[i] = 1;
            if (i > 0 && i < ratings.length - 1 &&
                ratings[i - 1] >= ratings[i] &&
                ratings[i] <= ratings[i + 1]) {
                this.solved[i] = true;
            } else if (i == 0 &&  ratings[i] <= ratings[i + 1]) {
                this.solved[i] = true;
            } else if (i == ratings.length - 1 && ratings[i - 1] >= ratings[i]) {
                this.solved[i] = true;
            }
        }

        for (int i = 0; i < ratings.length; ++i) {
            if (!this.solved[i]) {
                this.candies[i] = find_candy_dp(i);
            }
        }

        for (int i = 0; i < ratings.length; ++i) {
            candySum += this.candies[i];
        }

        return candySum;
    }
}