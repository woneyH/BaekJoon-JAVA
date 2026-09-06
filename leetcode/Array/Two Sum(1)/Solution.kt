class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..<nums.lastIndex) {
            var sum = nums[i]
            for (j in i+1..nums.lastIndex) {
                sum += nums[j]
                if (sum == target) {
                    return intArrayOf(i, j)
                }
                sum -= nums[j]
            }
        }
        return IntArray(2) { -1 }
    }
}
