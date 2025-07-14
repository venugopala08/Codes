import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(rowNum + 1, 1));

            for (int j = 1; j < rowNum; j++) {
                int val = triangle.get(rowNum - 1).get(j - 1) + triangle.get(rowNum - 1).get(j);
                row.set(j, val);
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        List<List<Integer>> ans = sol.generate(n);

        for (List<Integer> row : ans) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

