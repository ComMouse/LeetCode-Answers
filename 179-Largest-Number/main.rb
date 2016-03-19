# @param {Integer[]} nums
# @return {String}
def largest_number(nums)
    nums.sort! { |a, b| b.to_s + a.to_s <=> a.to_s + b.to_s }

    result = nums.join
    return result if result[0] != '0'
    result.to_i == 0 ? '0' : result
end

def test
    puts largest_number([0, 0])
end

test