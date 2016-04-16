# -*- coding: utf-8 -*-
# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Boolean}
def can_finish(num_courses, prerequisites)
    graph = Graph.new(num_courses, prerequisites)
    !graph.has_circle
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

        edges.each do |edge|
            @graph[edge[0]].push edge[1]
        end
    end

    # Check whether the graph has a circle.
    # @return {Integer[]}
    def has_circle
        @visited_map = Array.new(@num, false)
        @dfs_stack = Array.new(@num, false)

        @graph.each_index do |point|
            # Skip visited points
            next if @visited_map[point]
            # If a circle is found
            unless dfs(point)
                return true
            end
        end

        false
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

        # No circle found
        true
    end
end

puts has_circle(4, [[1,0],[2,0],[3,1],[3,2]]).to_s
puts has_circle(2, [[1, 0], [0, 1]]).to_s
puts has_circle(2, []).to_s
puts has_circle(8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5],[5,1],[6,4]]).to_s