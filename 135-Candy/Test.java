import java.util.Arrays;

/**
 * Main Test Cases.
 */
public class Test
{
    public static void main(String[] args)
    {
        int[] testCase1 = {1};
        test(testCase1, 1);

        int[] testCase2 = {3, 4};
        test(testCase2, 3);

        int[] testCase3 = {0};
        test(testCase3, 1);

        int[] testCase4 = {1, 2, 2};
        test(testCase4, 4);

        int[] testCase5 = {3, 2, 1};
        test(testCase5, 6);

        int[] testCase6 = {2, 2};
        test(testCase6, 2);

        int[] testCase7 = {1, 2, 2, 2, 3};
        test(testCase7, 7);
    }
    
    public static void test(int[] testCase, int key)
    {
        int result = (new Solution()).candy(testCase);
        if (result != key) {
            System.out.println("Test case failed: " +
                Arrays.toString(testCase) + " " +
                result + " given, " +
                key + " expected");
        }
    }
}