import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, maxlen = 0;

        while (right < s.length()) {
            if (!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                maxlen = Math.max(maxlen, right - left + 1);
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int ans = obj.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + ans);
    }
}


/*
 * 
 * 
 * 
---

## Intuition

* We need the **longest substring without duplicate characters**.
* A **window** is defined by two pointers: `left` and `right`.
* `window` (a HashSet) keeps track of the unique characters currently in the substring `s[left...right]`.

---

## Step-by-Step Explanation

1. **Initialization**

   * `left = 0`, `right = 0`, `maxlen = 0`.
   * `window` is empty.

2. **Slide right pointer until a duplicate is found**

   * At each step, check if `s[right]` is in the `window`.
   * If **not in window**: add it, update `maxlen`, move `right` one step forward.
   * If **already in window**: remove `s[left]` and move `left` forward by one.
   * This shrinking continues **until there is no duplicate**, then we expand again.

3. **Continue until right reaches end of string.**

   * Because we only move `left` or `right` forward, **no character is visited more than twice** → O(n) complexity.

---

## Where Does "Backtracking" Happen?

It’s **not backtracking in the recursion sense**, but the algorithm “backtracks” by moving the **left pointer** when a conflict (duplicate character) occurs:

* Suppose `s = "abcabcbb"`.
* Start: window = `{}`, left=0, right=0.
* Add 'a', 'b', 'c' → window = `{a,b,c}`, maxlen = 3.
* Next char 'a' at index 3 → duplicate!
* **Backtrack (shrink from left):**

  * Remove 'a' at left=0 → window = `{b,c}`, left=1.
  * Still duplicate? No → Now add new 'a'.
* This controlled shrinking is why we never re-scan the whole substring — **we only remove one char at a time** until valid.

---

## Dry Run Example

### Input: `"pwwkew"`

* Start: `left=0, right=0`, window=`{}`, maxlen=0
* Add 'p' → window `{p}` → maxlen=1
* Add 'w' → window `{p,w}` → maxlen=2
* Next 'w' (duplicate):

  * Remove 'p' (left=0→1), window `{w}`
  * Still duplicate? Remove first 'w' (left=1→2), window `{}`
  * Now add new 'w' at index=2
* Add 'k' → window `{w,k}` → maxlen still=2
* Add 'e' → window `{w,k,e}` → maxlen=3
* Next 'w' (duplicate):

  * Remove 'w' at left=2 → window `{k,e}`
  * Add new 'w'

Result: **3**

---

## Why Is This Optimal?

* **Time complexity:** O(n) because each character is added and removed from the set at most once.
* **Space complexity:** O(min(n, charset)) → For ASCII, max 128 chars.

---

## Final Key Points

* **Window always holds unique characters.**
* **Left pointer only moves forward**, never backward — but logically it "backtracks" to fix invalid substrings.
* **No recursion or full backtracking search is needed**, making this efficient.

---

Do you want me to draw **a detailed diagram showing how `left` and `right` move step-by-step** (visual sliding window with states)? Or should I write it **as a detailed backtracking-style trace table**?

 * 
 * 
 * 
 * 
 */