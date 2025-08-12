import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number -> index
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // value we need

            // If we've already seen the complement, return the indices
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            // Store the current number with its index
            seen.put(nums[i], i);
        }

        // Should never happen for valid inputs
        throw new IllegalArgumentException("No two sum solution");
    }
}


/*



Got it — I’ll give you:

1. **The full final Java code** for Two Sum using a hash map (optimized O(n) time).
2. A **detailed explanation** of how it works.
3. A **step-by-step dry run** to “trace” the execution.
4. The **brute-force backtracking-style approach** (O(n²)) for completeness.

---


```

---

## **🔍 How It Works**

1. **Goal:** Find two indices `(a, b)` such that `nums[a] + nums[b] == target`.
2. **Idea:**

   * While scanning the array, store each number and its index in a hash map.
   * Before storing, check if the complement (needed value) already exists.
3. **Why O(n) time?**

   * Each number is processed once (`O(n)`)
   * `HashMap` lookups are `O(1)` average case.

---

## **📜 Step-by-Step Dry Run**

Example:

```java
nums = [2, 7, 11, 15], target = 9
```

| Step | i | nums\[i] | complement | seen (map before) | Found? | Action         |
| ---- | - | -------- | ---------- | ----------------- | ------ | -------------- |
| 1    | 0 | 2        | 7          | {}                | No     | Store (2 → 0)  |
| 2    | 1 | 7        | 2          | {2=0}             | Yes    | Return \[0, 1] |

✅ Output: `[0, 1]`

---

## **💡 Why `return new int[]{seen.get(complement), i};`?**

* `seen.get(complement)` → index of the first number we saw earlier
* `i` → index of the current number
* Together, they form the pair of indices that sum to `target`.

---

## **🐢 Brute Force (Backtracking-like) Approach (O(n²) time)**

This is like “trying all possible pairs” (no optimization).
We check every `(i, j)` where `i < j` and see if they sum to target.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

### **Dry Run**

For `nums = [3, 2, 4], target = 6`:

1. `(0,1)` → 3+2=5 → no
2. `(0,2)` → 3+4=7 → no
3. `(1,2)` → 2+4=6 → yes → return `[1, 2]`.

---

## **⏱ Complexity Comparison**

| Approach                  | Time Complexity | Space Complexity |
| ------------------------- | --------------- | ---------------- |
| Brute Force (nested loop) | O(n²)           | O(1)             |
| Hash Map (optimized)      | O(n)            | O(n)             |

---

If you want, I can also **draw a memory map diagram** showing how the hash map fills step-by-step — that would make the process very visual.
Do you want me to make that diagram?


*/