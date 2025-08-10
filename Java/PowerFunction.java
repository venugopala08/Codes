public class PowerFunction {

    public double myPow(double x, int n) {
        double res = 1.0;

        // If exponent is negative, invert base and make exponent positive
        if (n < 0) {
            x = 1 / x;

            // Handling edge case: n could be Integer.MIN_VALUE (-2147483648)
            // Negating it directly will overflow, so we use a trick
            if (n == Integer.MIN_VALUE) {
                res *= x;  // multiply once for the extra power
                n += 1;    // now n is not min value
            }
            n = -n;
        }

        // Binary exponentiation (Exponentiation by squaring)
        while (n != 0) {
            // If n is odd, multiply result by x
            if ((n % 2) != 0) {
                res *= x;
            }
            // Square the base
            x *= x;

            // Divide exponent by 2 (using unsigned right shift for positive n)
            n >>>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        PowerFunction pf = new PowerFunction();
        System.out.println(pf.myPow(2.0, 10));  // 1024.0
        System.out.println(pf.myPow(2.0, -2));  // 0.25
        System.out.println(pf.myPow(3.0, 5));   // 243.0
    }
}


/*
 * 
 * 

---

## **Step-by-step Explanation**

The function implements **Binary Exponentiation** (also called **Exponentiation by Squaring**), which reduces the time complexity from **O(n)** to **O(log n)**.

### **Key Idea**

Instead of multiplying `x` by itself `n` times, we:

* Square `x` each time (to get powers faster).
* Reduce `n` by half in each step.
* Only multiply to the result when `n` is odd.

---

### **Algorithm Flow**

1. **Handle negative exponents**:
   If `n` is negative:

   * Take reciprocal of `x` (`x = 1/x`)
   * Make `n` positive (`n = -n`)
   * Edge case for `Integer.MIN_VALUE` is handled because `-n` overflows.

2. **Loop until `n` becomes 0**:

   * If `n` is odd → multiply result by `x`.
   * Square `x` → `x = x * x`.
   * Divide `n` by 2 → `n >>>= 1`.

3. Return `res`.

---

## **Dry Run (Backtracking)**

Let’s take `myPow(2.0, 10)`.

### Initial values:

```
x = 2.0
n = 10
res = 1.0
```

---

**Iteration 1:**

* `n = 10` (even) → skip multiplication
* Square `x`: `x = 2.0 * 2.0 = 4.0`
* Divide `n` by 2: `n = 10 / 2 = 5`

---

**Iteration 2:**

* `n = 5` (odd) → `res = res * x = 1.0 * 4.0 = 4.0`
* Square `x`: `x = 4.0 * 4.0 = 16.0`
* Divide `n` by 2: `n = 5 / 2 = 2`

---

**Iteration 3:**

* `n = 2` (even) → skip multiplication
* Square `x`: `x = 16.0 * 16.0 = 256.0`
* Divide `n` by 2: `n = 2 / 2 = 1`

---

**Iteration 4:**

* `n = 1` (odd) → `res = res * x = 4.0 * 256.0 = 1024.0`
* Square `x`: `x = 256.0 * 256.0 = 65536.0`
* Divide `n` by 2: `n = 1 / 2 = 0`

---

**End:**

* `n = 0` → return `res = 1024.0`

✅ Output: **1024.0**

---

## **Complexity Analysis**

* **Time Complexity**: `O(log n)` → because we halve `n` each iteration.
* **Space Complexity**: `O(1)` → only a few variables are used.

---

 * 
 * 
 * 
 */