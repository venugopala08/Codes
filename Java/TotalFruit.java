import java.util.*;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        // Step 1: Initialize sliding window pointers and hashmap
        int left = 0, maxFruits = 0, right = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        // Step 2: Expand window with right pointer
        while (right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // Step 3: Shrink window if more than 2 fruit types
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            // Step 4: Update max basket size
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }

        // Step 5: Return result
        return maxFruits;
    }

    public static void main(String[] args) {
        TotalFruit sol = new TotalFruit();

        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(sol.totalFruit(fruits)); // Output: 4 (subarray [1,2,1,2])
    }
}
