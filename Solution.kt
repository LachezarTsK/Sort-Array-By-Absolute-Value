
class Solution {

    private companion object {
        val RANGE_OF_VALUES = intArrayOf(-100, 100)
        const val OFFSET_NEGATIVES = 100
    }

    fun sortByAbsoluteValue(nums: IntArray): IntArray {
        val frequency = IntArray(RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1)
        for (value in nums) {
            ++frequency[value + OFFSET_NEGATIVES]
        }

        var index = 0
        for (value in 0..RANGE_OF_VALUES[1]) {
            while (frequency[-value + OFFSET_NEGATIVES] > 0) {
                nums[index] = -value
                ++index
                --frequency[-value + OFFSET_NEGATIVES]
            }
            while (frequency[OFFSET_NEGATIVES + value] > 0) {
                nums[index] = value
                ++index
                --frequency[OFFSET_NEGATIVES + value]
            }
        }
        return nums
    }
}
