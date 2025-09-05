import java.util.*;

public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        // Step 1: Initialize pointers and counters
        int left = 0, maxLength = 0, zeroCount = 0;

        // Step 2: Expand the window with right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++; // count zeros in window
            }

            // Step 3: Shrink window if zeros exceed k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++; // move left boundary forward
            }

            // Step 4: Update max window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Step 5: Return result
        return maxLength;
    }

    public static void main(String[] args) {
        LongestOnes sol = new LongestOnes();

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(sol.longestOnes(nums, k)); // Output: 6
    }
}
