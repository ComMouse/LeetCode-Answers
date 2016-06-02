import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
    	// TODO: This algorithm is slow due to heap implementation
        List<int[]> points = new ArrayList<>();
        List<int[]> skyline = new ArrayList<>();
        Queue<Integer> heightHeap = new PriorityQueue<>((a, b) -> (b - a));
        int prevMaxHeight = 0, currentMaxHeight = 0;
        
        for (int[] item : buildings) {
            points.add(new int[]{item[0], -item[2]});
            points.add(new int[]{item[1], item[2]});
        }
        
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        heightHeap.add(0);
        
        for (int[] point : points) {
            if (point[1] < 0) {
                heightHeap.add(-point[1]);
            } else if (point[1] > 0) {
                heightHeap.remove(point[1]);
            }
            
            currentMaxHeight = heightHeap.peek();
            if (currentMaxHeight != prevMaxHeight) {
                prevMaxHeight = currentMaxHeight;
                skyline.add(new int[]{point[0], currentMaxHeight});
            }
        }
        
        return skyline;
    }
}