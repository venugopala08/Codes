public class isPalindrome {
    // Function to check if a string is a palindrome
    public static boolean checkPalindrome(String s) {
        // Step 1: Clean the string - remove non-alphanumeric characters and convert to lowercase
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Step 2: Use two pointers to compare characters from both ends
        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false; // If any mismatch, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If no mismatches, it's a palindrome
    }

    // A backtracking-based palindrome check (recursive approach)
    public static boolean checkPalindromeRecursive(String clean, int left, int right) {
        // Base case: pointers have crossed or are equal → palindrome confirmed
        if (left >= right) return true;

        // If characters don't match → not a palindrome
        if (clean.charAt(left) != clean.charAt(right)) return false;

        // Recursive case: move both pointers inward
        return checkPalindromeRecursive(clean, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        
        // Iterative method
        boolean resultIterative = checkPalindrome(s);
        System.out.println("Is palindrome (iterative)? " + resultIterative);

        // Preparing string for recursive (backtracking) method
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        boolean resultRecursive = checkPalindromeRecursive(clean, 0, clean.length() - 1);
        System.out.println("Is palindrome (recursive)? " + resultRecursive);
    }
}



/*
 * 
 * 
 * 
 * Step-by-step Explanation

Cleaning the string:

We use replaceAll("[^A-Za-z0-9]", "") to remove everything except letters and digits.

Convert to lowercase to make it case-insensitive using toLowerCase().

Iterative two-pointer method:

Initialize left = 0 and right = clean.length()-1.

While left < right:

If clean.charAt(left) != clean.charAt(right), return false.

Move pointers inward (left++, right--).

If loop finishes without mismatch, return true.

Recursive backtracking method:

Base condition: if left >= right, return true (center reached).

If mismatch at any step, return false.

Else recursively call function with left+1 and right-1.

Main method:

Demonstrates both approaches on "A man, a plan, a canal: Panama".

Prints whether it's a palindrome using both iterative and recursive methods.



 */