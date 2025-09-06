
using System;

public class Solution
{
    private static readonly int[] RANGE_OF_VALUES = { -100, 100 };
    private static readonly int OFFSET_NEGATIVES = 100;

    public int[] SortByAbsoluteValue(int[] nums)
    {
        int[] frequency = new int[RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1];
        foreach (int value in nums)
        {
            ++frequency[value + OFFSET_NEGATIVES];
        }

        int index = 0;
        for (int value = 0; value <= RANGE_OF_VALUES[1]; ++value)
        {
            while (frequency[-value + OFFSET_NEGATIVES] > 0)
            {
                nums[index] = -value;
                ++index;
                --frequency[-value + OFFSET_NEGATIVES];
            }
            while (frequency[OFFSET_NEGATIVES + value] > 0)
            {
                nums[index] = value;
                ++index;
                --frequency[OFFSET_NEGATIVES + value];
            }
        }
        return nums;
    }
}
