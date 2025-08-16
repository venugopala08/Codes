
import java.util.*;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;  // Negative numbers can't be palindromes
        int rev = 0;
        int num = x;
        while (num != 0) {
            rev = rev * 10 + num % 10;  // Build reversed number
            num = num / 10;
        }
        return (rev == x);  // Check if original and reversed are same
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        boolean result = isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + result);
        sc.close();
    }
}

/*
```

### **Step-by-step explanation:**

1. **Negative numbers**: If `x < 0`, return false because `-121` is not a palindrome.
2. **Reverse building**:

   * Take the last digit using `num % 10`.
   * Add it to `rev` by multiplying `rev` by 10 and adding the digit.
   * Remove the last digit from `num` using `num / 10`.
3. **Compare**: At the end, if `rev == x`, it’s a palindrome.

### Example:

Input: `121`

* rev = 0 → 1 → 12 → 121
* Compare `121 == 121` → true

Input: `-121`

* Immediately false because negative.

Input: `10`

* rev = 0 → 0 → 1
* Compare `1 == 10` → false

Do you also want me to **explain this with backtracking steps like I did for longest substring** (tracing each digit removal and reverse building)? Or just keep it straightforward?


 */