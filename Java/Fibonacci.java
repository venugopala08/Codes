

import java.util.Scanner;

class Fibonacci {

    // Iterative approach (efficient)
    public int fibIterative(int n) {
        if (n <= 1) return n;  // Base cases: fib(0)=0, fib(1)=1
        
        int a = 0, b = 1;      // Start from first two Fibonacci numbers
        for (int i = 2; i <= n; i++) {
            int temp = b;      // Store current b before changing it
            b = a + b;         // Next Fibonacci number
            a = temp;          // Move forward
        }
        return b;
    }

    // Recursive approach (backtracking style)
    public int fibRecursive(int n) {
        if (n <= 1) return n;   // Base cases
        return fibRecursive(n - 1) + fibRecursive(n - 2); // Backtrack and sum
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibonacci sol = new Fibonacci();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // Iterative result
        int iterativeResult = sol.fibIterative(n);
        System.out.println("Fibonacci using iteration: " + iterativeResult);

        // Recursive result (backtracking)
        int recursiveResult = sol.fibRecursive(n);
        System.out.println("Fibonacci using recursion (backtracking): " + recursiveResult);

        sc.close();
    }
}


// Another function :
/* 

class Solution {
    public int fib(int n) {
        // Base case: first two Fibonacci numbers
        if (n <= 1) {
            return n;
        }
        // Recursive case (backtracking step)
        return fib(n - 1) + fib(n - 2);
    }
}

*/


/* 
## **How It Works (Backtracking Explanation)**

1. **Problem definition:**

   * Fibonacci sequence: `F(0)=0`, `F(1)=1`, and `F(n)=F(n-1)+F(n-2)` for n ≥ 2.
   * We just follow the definition directly.

2. **Base cases stop recursion:**

   * If `n == 0`, return 0.
   * If `n == 1`, return 1.

3. **Recursive expansion (backtracking):**

   * For any `n > 1`, we need to calculate `fib(n-1)` and `fib(n-2)` first.
   * We make **two recursive calls**, then combine their results.

4. **Example for n = 4:**

   * `fib(4)` → `fib(3) + fib(2)`
   * `fib(3)` → `fib(2) + fib(1)`
   * `fib(2)` → `fib(1) + fib(0)`
   * `fib(1) → 1`, `fib(0) → 0`
   * Combining back:

     * `fib(2) = 1 + 0 = 1`
     * `fib(3) = 1 + 1 = 2`
     * `fib(4) = 2 + 1 = 3`

   Each return unwinds the stack — this "backtracking" is just recursion unwinding.

---

## **Complexity**

* **Time Complexity:** O(2^n) (because each call spawns two calls).
* **Space Complexity:** O(n) (recursion stack depth).

This is **much slower** than your iterative solution (`O(n)` time, `O(1)` space), but it’s the **pure backtracking** approach as requested.

---

## **Key Takeaway**

* **Backtracking/recursive approach:** Clean, easy to write, mirrors the math definition, but slow.
* **Iterative approach (your code):** Fast, memory-efficient, but less "mathematical-looking".
* **Best in practice:** Use **dynamic programming (memoization)** to combine recursion clarity with efficiency.

Do you also want me to **show the memoized recursion (top-down DP)** version — which still uses recursion but avoids recomputation?


*/