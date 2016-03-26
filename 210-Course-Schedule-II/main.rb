# -*- coding: utf-8 -*-
# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Integer[]}
def find_order(num_courses, prerequisites)
    graph = Graph.new(num_courses, prerequisites)
    graph.topo_sort
end

# ---------------------
# Class Graph
# ---------------------
class Graph
	# Constructor.
	# @param {Integer} point_num
	# @param {Integer[][]} edges
    def initialize(point_num, edges)
        @num = point_num
        @graph = Array.new(@num) { [] }
        @visited_map = Array.new(@num, false)
        @dfs_stack = Array.new(@num, false)
        @topo_list = []

        edges.each do |edge|
            @graph[edge[0]].push edge[1]
        end
    end

    # Do topological sort.
    # @return {Integer[]}
    def topo_sort
        @visited_map = Array.new(@num, false)
        @dfs_stack = Array.new(@num, false)
        @topo_list = []

        @graph.each_index do |point|
            # Skip visited points
            next if @visited_map[point]
            # If a circle is found
            unless dfs(point)
                return []
            end
        end

        @topo_list
    end

    # Do depth-first search.
    # @param {Integer} point Point to search.
    # @param {Boolean} Whether a circle has been found.
    def dfs(point)
        @visited_map[point] = true
        @dfs_stack[point] = true

        @graph[point].each do |to_point|
            return false if @dfs_stack[to_point]  # A circle is found
            next if @visited_map[to_point]        # Visited point

            # Scan point recursively
            unless dfs(to_point)
                return false    # A circle is found
            end
        end

        @dfs_stack[point] = false
        @topo_list.push point

        # No circle found
        true
    end
end

puts find_order(4, [[1,0],[2,0],[3,1],[3,2]]).to_s
puts find_order(2, [[1, 0], [0, 1]]).to_s
puts find_order(2, []).to_s
puts find_order(8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5],[5,1],[6,4]]).to_s