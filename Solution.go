
package main
var RANGE_OF_VALUES = [2]int{-100, 100}
const OFFSET_NEGATIVES = 100

func sortByAbsoluteValue(nums []int) []int {
    frequency := make([]int, RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1)
    for _, value := range nums {
        frequency[value+OFFSET_NEGATIVES]++
    }

    index := 0
    for value := 0; value <= RANGE_OF_VALUES[1]; value++ {
        for frequency[-value + OFFSET_NEGATIVES] > 0 {
            nums[index] = -value
            index++
            frequency[-value + OFFSET_NEGATIVES]--
        }
        for frequency[OFFSET_NEGATIVES+value] > 0 {
            nums[index] = value
            index++
            frequency[OFFSET_NEGATIVES + value]--
        }
    }
    return nums
}
