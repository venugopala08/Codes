import java.util.Arrays;

public class longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        
        // If array is empty, no sequence exists
        if (nums.length == 0) return 0;
        
        // Sort the array to make consecutive numbers adjacent
        Arrays.sort(nums);
        
        int c = 1;   // current consecutive sequence length
        int max = 1; // maximum consecutive sequence length found so far
        
        for (int i = 0; i < nums.length - 1; i++) {
            
            if (nums[i] + 1 == nums[i+1]) {
                // Found next consecutive number, extend current streak
                c++;
            }
            else if (nums[i] == nums[i+1]) {
                // Duplicate number: skip it without breaking the streak
                continue;
            }
            else {
                // Not consecutive, reset current streak counter
                c = 1;
            }
            
            // Update maximum if current streak is longer
            max = Math.max(max, c);
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums));
    }
}



/* 
```

---

## **How It Works**

1. **Sorting step** (`Arrays.sort(nums)`)

   * Makes consecutive numbers appear next to each other.
   * Example: `[100, 4, 200, 1, 3, 2]` → `[1, 2, 3, 4, 100, 200]`.

2. **Loop through array**

   * If next number is exactly `nums[i] + 1`, increment streak.
   * If next number is equal to current (`nums[i] == nums[i+1]`), skip duplicates.
   * Otherwise, reset streak to `1`.

3. **Track max streak** using `Math.max(max, c)` each iteration.

4. **Return `max`** at the end.

---

## **Dry Run Example**

Input: `nums = [100, 4, 200, 1, 3, 2]`

* Sort → `[1, 2, 3, 4, 100, 200]`
* Start `c = 1`, `max = 1`

Step-by-step:

* Compare `1` and `2` → consecutive → `c=2`, `max=2`
* Compare `2` and `3` → consecutive → `c=3`, `max=3`
* Compare `3` and `4` → consecutive → `c=4`, `max=4`
* Compare `4` and `100` → break → `c=1`, `max=4`
* Compare `100` and `200` → break → `c=1`, `max=4`

Output = `4` (sequence: `[1, 2, 3, 4]`)

---

## **Complexity**

* **Time:** O(n log n) (because of sorting)
* **Space:** O(1) (no extra space apart from sorting in-place)

---


*/

/* 
## **Possible Optimized Solution**

If you need **O(n) time**, you can use a `HashSet`:

1. Put all numbers into a set.
2. Only start counting when the current number is the *start* of a sequence (`num-1` not in set).
3. Keep counting forward until the streak ends.

Would you like me to write the **O(n) HashSet solution** with explanation? Or stick with your sorted approach but improve readability?


*/


/*
 * 
 * 
 * 
 * Here’s the **O(n)** solution using a `HashSet`. This avoids sorting and works in linear time on average.

---

## **Optimal HashSet Solution (O(n) time)**

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Put all numbers into a set for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                // Count forward until the sequence ends
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
```









---

## **How This Works**

1. **Store all numbers in a HashSet:**

   * Lookups are O(1) on average.
   * Duplicates automatically disappear.

2. **Only start counting at sequence beginnings:**

   ```java
   if (!set.contains(num - 1)) { ... }
   ```

   This ensures we only count each sequence once, starting at its first element.

3. **Count the streak length by scanning forward:**

   ```java
   while (set.contains(currentNum + 1)) { ... }
   ```

   This loop counts how long the consecutive sequence goes.

4. **Track maximum streak length:**

   ```java
   longest = Math.max(longest, streak);
   ```

---

## **Dry Run Example**

Input: `nums = [100, 4, 200, 1, 3, 2]`

* `set = {100, 4, 200, 1, 3, 2}`

Loop through set:

* For `100` → `set.contains(99)` is false → streak = 1 → longest = 1
* For `4` → `set.contains(3)` is true → skip (not a start)
* For `200` → `set.contains(199)` is false → streak = 1 → longest = 1
* For `1` → `set.contains(0)` is false → count forward: 1 → 2 → 3 → 4 → streak = 4 → longest = 4
* For `3` → skip (already counted)
* For `2` → skip (already counted)

Result = `4`.

---

## **Complexity**

* **Time Complexity:** O(n) average

  * Building set → O(n)
  * Loop through set → O(n) (each number visited at most twice: once in main loop, once in inner while)
* **Space Complexity:** O(n) for the set

---

Do you want me to **add comments inside the code for each step** so it’s crystal clear when reading later? Or should I write a **visual diagram of how the set and counters evolve**?

 * 
 * 
 * 
 * 
 * 
 * 
 */