#include <iostream>
#include <string>
#include <vector>
#include "Solution.hpp"

using namespace std;

void test(vector<string>& input, int assert_result)
{
	// Serialize input
	vector<vector<char>> grid;
	for (const string& line : input)
	{
		vector<char> grid_row;
		for (char c : line)
			grid_row.push_back(c);
		grid.push_back(grid_row);
	}

	// Test and compare
	Solution solution;
	int test_result = solution.numIslands(grid);
	if (test_result == assert_result)
		cout << "Test case passed." << endl;
	else
		cout << "Test case failed: Shoule be " << assert_result << ", get " << test_result << "." << endl;
}

int main()
{
	vector<string> case1 = {
		"11110",
		"11010",
		"11000",
		"00000"
	};

	test(case1, 1);

	vector<string> case2 = {
		"11000",
		"11000",
		"00100",
		"00011"
	};

	test(case2, 3);

	return 0;
}