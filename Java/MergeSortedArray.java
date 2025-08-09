import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int end = nums1.length - 1; // last index of nums1

        while (m > 0 && n > 0) {
            if (nums2[n - 1] >= nums1[m - 1]) {
                nums1[end] = nums2[n - 1];
                n--;
            } else {
                nums1[end] = nums1[m - 1];
                m--;
            }
            end--;
        }

        while (n > 0) {
            nums1[end] = nums2[n - 1];
            n--;
            end--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before merge: " + Arrays.toString(nums1));
        obj.merge(nums1, m, nums2, n);
        System.out.println("After merge:  " + Arrays.toString(nums1));
    }
}



/*

Nice — let’s dig deep. I’ll explain the algorithm, prove why it’s correct, walk through **detailed step-by-step traces** (the “backtracking” you asked for), cover edge cases, complexity, and show an annotated version of the full code.

# Problem recap (short)

You have two sorted arrays:

* `nums1` has length `m + n`. The first `m` elements are valid sorted numbers; the last `n` elements are zeros (space for merging).
* `nums2` has `n` sorted numbers.

Goal: Merge `nums2` into `nums1` **in-place** so `nums1` becomes the sorted array of size `m + n`.

---

# Algorithm idea (why fill from the end)

If you merge from the front, you risk overwriting elements of `nums1` that haven't been considered yet. To avoid that, use three pointers and fill `nums1` **from the back**:

* `p1 = m - 1` — points to last valid element of `nums1`
* `p2 = n - 1` — points to last element of `nums2`
* `write = m + n - 1` — index in `nums1` where we write the next largest element

While both `p1 >= 0` and `p2 >= 0`:

* compare `nums1[p1]` and `nums2[p2]`
* put the larger at `nums1[write]`
* decrement the pointer of the element you took and decrement `write`.

After the main loop, if `p2 >= 0` there are still elements in `nums2` to copy — copy them into `nums1[0..write]`. (If `p1 >= 0` and `p2 < 0`, remaining `nums1` elements are already in place.)

This is what your code does.

---

# Annotated code (readable, with comments)

```java
import java.util.Arrays;

public class MergeSortedArray {

    // Merge nums2 into nums1 in-place. m = number of valid elements in nums1,
    // n = number of elements in nums2.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers to last elements of the valid parts
        int p1 = m - 1;              // last element in nums1's valid portion
        int p2 = n - 1;              // last element in nums2
        int write = m + n - 1;       // position to write next largest element

        // Place larger of nums1[p1] and nums2[p2] at nums1[write]
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] >= nums1[p1]) {
                nums1[write] = nums2[p2];
                p2--;
            } else {
                nums1[write] = nums1[p1];
                p1--;
            }
            write--;
        }

        // If nums2 still has elements, copy them (nums1 leftover are already in place)
        while (p2 >= 0) {
            nums1[write] = nums2[p2];
            p2--;
            write--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        obj.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
    }
}
```

---

# Correctness (invariant & intuition)

**Invariant**: After every iteration of the main loop, the region `nums1[write+1 .. end]` contains the largest `(end - write)` elements among all elements originally in `nums1` and `nums2`, sorted in non-decreasing order.

* Initially `write = m + n - 1` and that suffix is empty → invariant holds vacuously.
* On each step we place the largest remaining element at `nums1[write]`, so we extend the sorted suffix by one while preserving order.
* Eventually either `p2 < 0` (all `nums2` merged) — then the rest of `nums1` is already in place — or `p1 < 0` (all original `nums1` used) — then we must copy the remaining `nums2` elements, which belong in front.

This proves we always place correct elements in descending order from the end, yielding a fully sorted array.

---

# Time & Space complexity

* Time: `O(m + n)` — each element is written exactly once and compared at most once.
* Extra space: `O(1)` — in-place, only a few index variables.

---

# Common pitfalls / gotchas

* **Wrong initial indices**: `p1` must be `m - 1`, `p2` `n - 1`, `write` `m + n - 1`.
* **Forgetting to copy remaining `nums2`**: if `p1` runs out first, we must copy the rest of `nums2`.
* **Using >= vs >**: your code uses `>=` (you place `nums2` element when equal). Either `>=` or `>` is fine; choosing `>=` results in taking `nums2` when equal. This doesn't break correctness.
* **Confusing `m` and `nums1.length`**: `m` is count of valid elements, not `nums1.length`. `nums1.length` is `m + n`.
* **Using Collections.swap** etc. — `nums1` is `int[]`, not a `List`.

---

# Detailed trace (step-by-step) — the example

`nums1 = [1,2,3,0,0,0]`, `m = 3`
`nums2 = [2,5,6]`, `n = 3`
Initial pointers:

* `p1 = 2` (`nums1[2] = 3`)
* `p2 = 2` (`nums2[2] = 6`)
* `write = 5`

We’ll show the array and the pointer values each step:

1. Compare `nums1[2]=3` vs `nums2[2]=6`: 6 ≥ 3 → write 6
   `nums1` becomes `[1,2,3,0,0,6]`
   update: `p2 = 1`, `write = 4`

2. Compare `nums1[2]=3` vs `nums2[1]=5`: 5 ≥ 3 → write 5
   `nums1` becomes `[1,2,3,0,5,6]`
   update: `p2 = 0`, `write = 3`

3. Compare `nums1[2]=3` vs `nums2[0]=2`: 2 < 3 → write 3 (from nums1)
   `nums1` becomes `[1,2,3,3,5,6]`
   update: `p1 = 1`, `write = 2`

4. Compare `nums1[1]=2` vs `nums2[0]=2`: 2 ≤ 2 and code uses `>=` on nums2, so we take nums2\[0]
   write 2 (from nums2)
   `nums1` becomes `[1,2,2,3,5,6]`
   update: `p2 = -1`, `write = 1`

Now `p2 < 0`, so we exit the main loop. Remaining `nums1` elements (`p1=1..0`) are already correct and in-place. Final `nums1` is `[1,2,2,3,5,6]`.

---

# More example traces (edge cases)

1. `m = 0`, `nums1 = [0,0,0]`, `nums2 = [1,2,3]`:

   * `p1 = -1`, `p2 = 2`, `write = 2`
   * Main while exits immediately; copy remaining `nums2` into `nums1` -> `[1,2,3]`.

2. `nums1` has larger tail: `nums1 = [4,5,6,0,0,0]`, `m=3`, `nums2=[1,2,3]`:

   * Steps will move 6,5,4 into end from nums1, then copy nums2 into front -> `[1,2,3,4,5,6]`.

3. All equal elements:

   * e.g., `nums1 = [1,1,1,0,0,0]`, `nums2=[1,1,1]`
   * Using `>=` we tend to pick from `nums2` when equal; result is still correct: six 1s.

---

# Alternative approaches (tradeoffs)

1. **Copy and sort**

   * `System.arraycopy(nums2, 0, nums1, m, n);`
   * `Arrays.sort(nums1);`
   * Time: `O((m+n) log(m+n))`, Space: `O(1)`
   * Simpler but slower.

2. **Merge into new array, then copy back**

   * Classic merge with O(m+n) time but requires O(m+n) extra space.

3. **Two-pointer forward merge with shifting**

   * Very inefficient if you shift many elements (O(m\*n) worst case) — avoid.

Your in-place backward merge is optimal: `O(m+n)` time and `O(1)` extra space.

---

# Unit tests to try

* `m = 0` and `n > 0` (nums1 should become nums2)
* `n = 0` (nums1 should remain unchanged)
* duplicate values across arrays
* all nums1 elements > all nums2 elements and vice-versa
* large arrays for performance

---


 */