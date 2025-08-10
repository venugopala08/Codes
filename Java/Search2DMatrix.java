public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;             // Total rows
        int col = matrix[0].length;          // Total columns
        int low = 0;                         
        int high = (row * col) - 1;           // Last index if matrix was flattened

        while (low <= high) {
            int mid = (low + high) / 2;

            // Mapping the 1D mid index back to 2D matrix coordinates
            int midVal = matrix[mid / col][mid % col];

            if (midVal == target) {
                return true; // Found
            } else if (midVal > target) {
                high = mid - 1; // Search in left half
            } else {
                low = mid + 1;  // Search in right half
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        boolean found = obj.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found? " + found);
    }
}



/*
 * 
 * 
 * How the Algorithm Works
The given matrix has two properties:

Each row is sorted in ascending order.

The first integer of each row is greater than the last integer of the previous row.

This means we can treat the 2D matrix like a sorted 1D array of size row * col.

Step 1: Treat indices 0 to (row*col - 1) as a sorted array.

Step 2: Perform binary search on this range.

Step 3: Convert the mid index to 2D coordinates:

Row index = mid / col

Column index = mid % col

Step 4: Compare matrix[rowIndex][colIndex] with target:

If equal → found.

If greater → move high to mid - 1.

If smaller → move low to mid + 1.



Dry Run (Backtracking of Variables)
Example:

matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 3


Initial:

row = 3
col = 4
low = 0
high = (3 * 4) - 1 = 11


Iteration 1:

mid = (0 + 11) / 2 = 5
mid/col = 5/4 = 1 → row index = 1
mid%col = 5%4 = 1 → col index = 1
midVal = matrix[1][1] = 11

11 > 3 → high = mid - 1 = 4


Iteration 2:

low = 0
high = 4
mid = (0 + 4) / 2 = 2
mid/col = 2/4 = 0 → row index = 0
mid%col = 2%4 = 2 → col index = 2
midVal = matrix[0][2] = 5

5 > 3 → high = mid - 1 = 1


Iteration 3:

low = 0
high = 1
mid = (0 + 1) / 2 = 0
mid/col = 0/4 = 0 → row index = 0
mid%col = 0%4 = 0 → col index = 0
midVal = matrix[0][0] = 1

1 < 3 → low = mid + 1 = 1


Iteration 4:

low = 1
high = 1
mid = (1 + 1) / 2 = 1
mid/col = 1/4 = 0 → row index = 0
mid%col = 1%4 = 1 → col index = 1
midVal = matrix[0][1] = 3

3 == 3 → FOUND → return true
 * 
 * 
 * 
 * 
 */