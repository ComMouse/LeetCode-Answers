public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int prevCandy = 1;              // Candy number of the previous child
        int startCandy = prevCandy;     // Candy number of startIndex
        int startIndex = 0;             // Start index of ascending/descending sequence
        int candySum = prevCandy;       // Candy sum

        for (int i = 1; i < ratings.length; ++i) {
            // Increase for ascending sequence
            if (ratings[i - 1] < ratings[i]) {
                startCandy = ++prevCandy;
                startIndex = i;
            // Keep 0 for equal neighbours
            } else if (ratings[i - 1] == ratings[i]) {
                startCandy = 1;
                prevCandy = 1;
                startIndex = i;
            // For descending sequence
            } else {
                // Update sum if the length of sequence is larger than candies of its start
                if (i - startIndex + 1 > startCandy) {
                    startCandy = i - startIndex + 1;
                    candySum += 1;
                }

                // Update the last candy number in the sequence
                // (Use -1 for the trick of the "prevCandy = 1" line)
                candySum += i - startIndex - 1;

                // Restore ascending candy counter
                prevCandy = 1;
            }

            // Add current candy number to sum
            candySum += prevCandy;
        }

        return candySum;
    }
}