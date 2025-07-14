

class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        triangle = []

        for num_Rows in range(numRows):
            row = [1] * (num_Rows + 1)
            for j in range(1,num_Rows):
                row[j] = triangle[num_Rows-1][j-1]+triangle[num_Rows-1][j]
            triangle.append(row)
        return triangle

if __name__ == "__main__":
    n = 5
    solution = Solution()
    result = solution.generate(n)
    for row in result:
        for value in row:
            print(value, end=' ')
        print()

    