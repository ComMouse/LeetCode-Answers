class Interval
    attr_accessor :start, :end
    def initialize(s=0, e=0)
        @start = s
        @end = e
    end
end

# Definition for an interval.
# class Interval
#     attr_accessor :start, :end
#     def initialize(s=0, e=0)
#         @start = s
#         @end = e
#     end
# end

# @param {Interval[]} intervals
# @return {Interval[]}
def merge(intervals)
    # Sort by start of intervals
    intervals.sort! { |a, b| a.start <=> b.start }

    # Merge intervals
    merged_intervals = []
    last_interval = nil
    intervals.each do |interval|
        # If need merging
        if !last_interval.nil? && interval.start <= last_interval.end
            last_interval.end = [last_interval.end, interval.end].max
            next
        end

        # If a new interval is found
        last_interval = interval
        merged_intervals.push interval
    end

    # Return result
    merged_intervals
end

# Run test cases.
def test
    test_case = [[1,3],[2,6],[8,10],[15,18]].map { |interval| Interval.new(interval[0], interval[1]) }
    test_result = [[1,6],[8,10],[15,18]]

    result = merge(test_case).map { |interval| [interval.start, interval.end] }

    if (test_result != result)
        puts 'Result failed: ' + result.to_s
    else
        puts 'Result passed'
    end
end

# Start testing
test