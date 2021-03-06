public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dis = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len2; ++i) {
            dis[0][i] = i;
        }
        for (int i = 0; i <= len1; ++i) {
            dis[i][0] = i;
        }
        
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dis[i][j] = dis[i - 1][j - 1];
                } else {
                    dis[i][j] = Math.min(Math.min(dis[i - 1][j - 1], dis[i][j - 1]), dis[i - 1][j]) + 1;
                }
            }
        }
        
        return dis[len1][len2];
    }
}