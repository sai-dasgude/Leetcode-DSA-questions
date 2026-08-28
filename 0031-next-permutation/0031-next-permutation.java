class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return;
        }

        int last = n - 2;
        boolean find = false;

        while (last >= 0 && !find) {

            int next_large_index =
                    find_next_largest_index(nums, last, n);

            if (next_large_index != -1) {

                int temp = nums[last];
                nums[last] = nums[next_large_index];
                nums[next_large_index] = temp;

                rev(nums, last + 1, n - 1);

                find = true;
            }

            last--;
        }

        // No next permutation
        if (!find) {
            rev(nums, 0, n - 1);
        }
    }


    public int find_next_largest_index(
            int[] nums,
            int curr,
            int n) {

        int curr_value = nums[curr];

        int next_largest = Integer.MAX_VALUE;
        int next_largest_index = -1;

        for (int i = curr + 1; i < n; i++) {

            if (nums[i] > curr_value &&
                nums[i] <= next_largest) {

                next_largest = nums[i];
                next_largest_index = i;
            }
        }

        return next_largest_index;
    }


    public void rev(
            int[] nums,
            int startindex,
            int endindex) {

        while (startindex <= endindex) {

            int temp = nums[startindex];

            nums[startindex] = nums[endindex];

            nums[endindex] = temp;

            startindex++;
            endindex--;
        }
    }
}