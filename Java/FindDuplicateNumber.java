public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle (Floyd's Tortoise and Hare)
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // Duplicate number
    }

    public static void main(String[] args) {
        FindDuplicateNumber obj = new FindDuplicateNumber();

        int[] nums = {1, 3, 4, 2, 2}; // Example input
        int duplicate = obj.findDuplicate(nums);

        System.out.println("Duplicate number is: " + duplicate);
    }
}





/*
 * 
 * 
 * Alright — let’s break this down step-by-step and deeply understand what’s going on with this `findDuplicate` method.
This problem is a **LeetCode classic**: *Find the Duplicate Number* solved with **Floyd’s Tortoise and Hare (Cycle Detection) algorithm**.

---

## **Problem Context**

We’re given:

* An array `nums` of size `n + 1`.
* Each integer is between `1` and `n` (inclusive).
* There’s **exactly one duplicate number** but it can appear multiple times.
* We **cannot modify** the array and should use **O(1) extra space**.

The trick:
We **treat the array as a linked list**, where the value at each index points to the next index.

---

## **Idea**

Think of `nums[i]` as:

```
i --> nums[i]
```

So the array creates a sequence of "pointers".
Since there’s a duplicate, one number will have **two incoming edges**, forming a **cycle**.

---

### **Step 1: Detect the cycle (Phase 1)**

```java
int slow = nums[0];
int fast = nums[0];
do {
    slow = nums[slow];          // move slow pointer 1 step
    fast = nums[nums[fast]];    // move fast pointer 2 steps
} while (slow != fast);
```

* **slow** moves 1 step at a time.
* **fast** moves 2 steps at a time.
* Eventually, because there’s a cycle, they will meet **inside the cycle**.

📌 **Why they meet:**
In a cycle, a faster runner will always catch up to a slower runner if they run infinitely.

---

### **Step 2: Find the entry point of the cycle (duplicate number)**

```java
slow = nums[0];  // reset slow to start
while (slow != fast) {
    slow = nums[slow];  // move both 1 step
    fast = nums[fast];
}
return slow;  // this is the duplicate number
```

Now:

* `slow` starts at the **head** (index `0`).
* `fast` stays where they met.
* Both move **one step at a time**.
* They meet again at the **cycle start**, which is the **duplicate number**.

---

## **Example Walkthrough**

### Input:

```
nums = [1, 3, 4, 2, 2]
```

Indexes: 0  1  2  3  4
Values:  1  3  4  2  2

Connections:

```
0 → 1 → 3 → 2 → 4
          ↑     ↓
          ← ← ←
```

The cycle is `2 → 4 → 2`.

---

### **Phase 1 (detect cycle)**:

```
slow = nums[0] = 1
fast = nums[0] = 1

Iteration 1:
slow = nums[1] = 3
fast = nums[ nums[1] ] = nums[3] = 2

Iteration 2:
slow = nums[3] = 2
fast = nums[ nums[2] ] = nums[4] = 2

Now slow == fast == 2 → cycle detected.
```

---

### **Phase 2 (find start of cycle)**:

```
slow = nums[0] = 1
fast = 2 (from phase 1)

Iteration 1:
slow = nums[1] = 3
fast = nums[2] = 4

Iteration 2:
slow = nums[3] = 2
fast = nums[4] = 2

slow == fast == 2 → duplicate found!
```

✅ Output: **2**

---

## **Why This Works**

This is just **Floyd’s cycle detection** but applied to an array where `nums[i]` acts as the next pointer.

* The **duplicate number** is the **entry point of the cycle**.
* We never modify the array and only use constant extra space.

---

## **Time & Space Complexity**

* **Time:** `O(n)` — each pointer visits at most `n` elements.
* **Space:** `O(1)` — no extra structures used.

---

If you want, I can also **draw the pointer movement diagram** so you can *visually* see how slow and fast meet. That makes the backtracking part super clear.
Do you want me to make that diagram?

 * 
 * 
 */