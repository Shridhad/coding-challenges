package dev.shriidhar.leetcode.minoperation;

public class MinOperation {

    public static int minOperations(int[] nums, int x) {
        int total = 0, length = nums.length;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target == 0) return length;
        if (target < 0) return -1;

        int leftIndex = 0, sum = 0, maxLength = 0;

        for (int rightIndex = 0; rightIndex < length; rightIndex++) {
            sum += nums[rightIndex];

            while (leftIndex <= rightIndex && sum > target) {
                sum -= nums[leftIndex];
                leftIndex++;
            }
            if (sum == target) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            }
        }

        return maxLength != 0 ? length - maxLength : -1;
    }
}
