
function sortByAbsoluteValue(nums: number[]): number[] {
    const RANGE_OF_VALUES = [-100, 100];
    const OFFSET_NEGATIVES = 100;
    const frequency: number[] = new Array(RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1).fill(0);
    for (let value of nums) {
        ++frequency[value + OFFSET_NEGATIVES];
    }

    let index = 0;
    for (let value = 0; value <= RANGE_OF_VALUES[1]; ++value) {
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
};
