#pragma once
#include <vector>
using namespace std;

class Solution {
public:
	int numIslands(vector<vector<char>>& grid)
	{
		int islandCount = 0;
		int height = grid.size();
		int width = height ? grid[0].size() : 0;

		for (int i = 0; i < height; ++i)
		{
			for (int j = 0; j < width; ++j)
			{
				// Skip explored grid or water grid
				if (grid[i][j] != '1')
					continue;

				scanIsland(grid, i, j, width, height);
				++islandCount;
			}
		}

		return islandCount;
	}
private:
	void scanIsland(vector<vector<char>>& grid, int y, int x, int w, int h)
	{
		if (x < 0 || x >= w || y < 0 || y >= h)
			return;

		// Skip water or marked grid
		if (grid[y][x] != '1')
			return;

		// Mark as explored
		grid[y][x] = 'E';

		// DFS
		scanIsland(grid, y + 1, x, w, h);
		scanIsland(grid, y - 1, x, w, h);
		scanIsland(grid, y, x + 1, w, h);
		scanIsland(grid, y, x - 1, w, h);
	}
};
