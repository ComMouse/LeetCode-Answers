public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        // Init values
        int w = matrix[0].length;
        int h = matrix.length;
        int maxPath = -1;
        
        // Path table
        int[][] path = new int[h][w];
        
        // Iterate each grid and dfs
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                maxPath = Math.max(dfs(j, i, Integer.MAX_VALUE, w, h, matrix, path), maxPath);
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int x, int y, int lastVal, int w, int h, int[][] matrix, int[][] path) {
        // Out of boundary
        if (x < 0 || x >= w || y < 0 || y >= h)
            return 0;
            
        int val = matrix[y][x];
        
        // Matrix value larger than lastVal
        if (val >= lastVal)
            return 0;
            
        // Visited
        if (path[y][x] > 0)
            return path[y][x];
        
        // DFS
        int left  = dfs(x - 1, y, val, w, h, matrix, path);
        int right = dfs(x + 1, y, val, w, h, matrix, path);
        int up    = dfs(x, y - 1, val, w, h, matrix, path);
        int down  = dfs(x, y + 1, val, w, h, matrix, path);
        
        // Update max path
        int max = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
        path[y][x] = max;
        
        return max;
    }
}