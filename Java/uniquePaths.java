class Solution {
    public int uniquePaths(int m, int n) {
        // Step 1: Create a DP table with m rows and n columns
        int dp[][] = new int[m][n];

        // Step 2: Fill the first column with 1
        // Because in the first column, you can only move DOWN from the start
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        // Step 3: Fill the first row with 1
        // Because in the first row, you can only move RIGHT from the start
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        // Step 4: Fill the rest of the grid
        // Each cell's value = paths from above + paths from left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Step 5: The bottom-right cell contains the total number of paths
        return dp[m - 1][n - 1];
    }
}



/*
 * 
 * 

---

## **Problem Understanding**

You’re given an `m x n` grid.
You start from the **top-left corner** `(0,0)` and want to reach the **bottom-right corner** `(m-1, n-1)`.

**Rules**:

* You can only move **right** or **down** at each step.
* Find the **number of unique paths**.

---


## **Logic Behind It**

### Why `dp[i][j] = dp[i-1][j] + dp[i][j-1]`?

* To reach `(i,j)`, you must come from:

  1. **Above** `(i-1, j)`
  2. **Left** `(i, j-1)`
* Since those are the only two ways to get here, total paths = sum of both.

---

## **Dry Run / Backtracking Table Fill**

Let’s try **m = 3**, **n = 3**.

**Step 1:** Initialize `dp[ ][ ]` as empty:

```
_ _ _
_ _ _
_ _ _
```

**Step 2:** Fill first row and column with 1:

```
1 1 1
1 _ _
1 _ _
```

**Step 3:** Start from `(1,1)` and fill using formula:

* `dp[1][1] = dp[0][1] + dp[1][0] = 1 + 1 = 2`

```
1 1 1
1 2 _
1 _ _
```

* `dp[1][2] = dp[0][2] + dp[1][1] = 1 + 2 = 3`

```
1 1 1
1 2 3
1 _ _
```

* `dp[2][1] = dp[1][1] + dp[2][0] = 2 + 1 = 3`

```
1 1 1
1 2 3
1 3 _
```

* `dp[2][2] = dp[1][2] + dp[2][1] = 3 + 3 = 6`

```
1 1 1
1 2 3
1 3 6
```

**Step 4:** Final answer = `dp[2][2] = 6` paths.

---

## **Backtracking View (Conceptual)**

Even though this is DP, you can imagine the **backtracking** process:

* From `(m-1, n-1)`, you can trace back to `(0,0)` by going **up** or **left**.
* Every path you trace backwards corresponds to a valid forward path.

For `(2,2)`:

```
From (2,2) → (1,2) → (0,2) → (0,1) → (0,0)
From (2,2) → (1,2) → (1,1) → (0,1) → (0,0)
From (2,2) → (1,2) → (1,1) → (1,0) → (0,0)
From (2,2) → (2,1) → (1,1) → (0,1) → (0,0)
From (2,2) → (2,1) → (1,1) → (1,0) → (0,0)
From (2,2) → (2,1) → (2,0) → (1,0) → (0,0)
```

That’s **6** unique ways.

---

 * 
 * 
 * 
 * 
 * 
 */