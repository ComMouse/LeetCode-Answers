# -*- coding: utf-8 -*-

# -----------------------------------
# Class Heap
# -----------------------------------
# Simple binary heap implementation.
# 
class Heap
    attr_reader :size    # Size getter

    # Constructor.
    # @param {bool} max Max heap or min heap.
    def initialize(max = true)
        @array = [nil]
        @size = 0
        @maxHeap = max
    end

    # Insert an element into the heap.
    # @param {integer} num
    def insert(num)
        @array.push num
        @size += 1
        adjust_bottom(@size)
    end

    # Remove an element from the heap.
    # @param {integer} num
    def remove(num)
        index = @array.index(num)
        return if index.nil? || index == 0

        swap(index, @size)
        @array.pop
        @size -= 1

        adjust_top(index)
    end

    # Get the top element in the heap.
    # @return {integer}
    def top
        @array[1]
    end

    # Get the top element in the heap and delete it.
    # @return {integer}
    def pop
        val = top
        remove(val)
        val
    end

    private

    # Adjust heap from top to bottom
    # @param {integer} index
    def adjust_top(index)
        while index * 2 <= @size do
            index *= 2
            index = index + 1 if index + 1 <= @size && compare(index + 1, index)

            swap(index, index / 2) if compare(index, index / 2)
        end
    end

    # Adjust heap from bottom to top
    # @param {integer} index
    def adjust_bottom(index)
        while index / 2 > 0 do
            swap(index, index / 2) if compare(index, index / 2)
            index /= 2
        end
    end

    # Compare two elements in the heap
    # @param {integer} x
    # @param {integer} y
    def compare(x, y)
        @maxHeap ? @array[x] > @array[y] : @array[x] < @array[y]
    end

    # Swap two elements in the heap
    # @param {integer} x
    # @param {integer} y
    def swap(x, y)
        @array[x], @array[y] = @array[y], @array[x]
    end
end

# -----------------------------------
# Class MedianFinder
# -----------------------------------
# Median finder.
# 
class MedianFinder
    # Constructor.
    def initialize
        @max_heap = Heap.new(true)
        @min_heap = Heap.new(false)
    end

    # Adds a num into the data structure.
    # @param {integer} word
    # @return {void}
    def add_num(num)
        median = find_median()
        if (median.nil?)
            @max_heap.insert num
            return
        end

        # Divide the heap by median
        if num > median
            @min_heap.insert num
            # Balancing median
            @max_heap.insert(@min_heap.pop) if @min_heap.size - @max_heap.size > 1
        else
            @max_heap.insert num
            # Balancing median
            @min_heap.insert(@max_heap.pop) if @max_heap.size - @min_heap.size > 1
        end
    end

    # Returns median of current data stream
    # @return {double}
    def find_median()
        case @min_heap.size - @max_heap.size
        when 0
        	return @min_heap.top if @max_heap.top.nil?
        	return @max_heap.top if @min_heap.top.nil?
            (@min_heap.top + @max_heap.top) / 2.0
        when -1
            @max_heap.top + 0.0        # Output must be float
        when 1
            @min_heap.top + 0.0        # Output must be float
        end
    end
end

# Test method
def test(data, answer)
    #puts "New test case"
    mf = MedianFinder.new
    for val in data
        mf.add_num(val)
    end

    key = mf.find_median
    puts "Answer should be #{answer}, get #{key}" if (key != answer)
end

# Test cases
test([2, 3, 4], 3)
test([2, 3], 2.5)
test([3, 12, 9, 5, 7, 4, 6], 6)
test([0, 0], 0)
test([6, 10, 2, 6, 5, 0], 5.5)

# Your MedianFinder object will be instantiated and called as such:
# mf = MedianFinder.new
# mf.add_num(1)
# mf.find_median()