
#include <array>
#include <vector>
using namespace std;

class Solution {

    static constexpr array<int, 2> RANGE_OF_VALUES { { -100, 100 } };
    static const int OFFSET_NEGATIVES = 100;

public:
    vector<int> sortByAbsoluteValue(vector<int>& nums) const {
        array<int, RANGE_OF_VALUES[1] + OFFSET_NEGATIVES + 1>  frequency{};
        for (const auto& value : nums) {
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
};
