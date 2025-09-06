
public class Solution {

    private static final int[] RANGE_OF_VALUES = {-100, 100};
    private static final int OFFSET_NEGATIVES = 100;

    public int[] sortByAbsoluteValue(int[] nums) {
        int[] frequency = new int[RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1];
        for (int value : nums) {
            ++frequency[value + OFFSET_NEGATIVES];
        }

        int index = 0;
        for (int value = 0; value <= RANGE_OF_VALUES[1]; ++value) {
            while (frequency[-value + OFFSET_NEGATIVES] > 0) {
                nums[index] = -value;
                ++index;
                --frequency[-value + OFFSET_NEGATIVES];
            }
            while (frequency[OFFSET_NEGATIVES + value] > 0) {
                nums[index] = value;
                ++index;
                --frequency[OFFSET_NEGATIVES + value];
            }
        }
        return nums;
    }
}
