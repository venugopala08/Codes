class Solution:
    def nextPermutation(self, nums):
        n = len(nums)
        ind = -1

        # Step 1: Find the first decreasing element from the end
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                ind = i
                break

        # Step 2: If not found, reverse the entire list
        if ind == -1:
            nums.reverse()
            return

        # Step 3: Find element just greater than nums[ind]
        for i in range(n - 1, ind, -1):
            if nums[i] > nums[ind]:
                nums[i], nums[ind] = nums[ind], nums[i]
                break

        # Step 4: Reverse the sublist from ind + 1 to end
        nums[ind + 1:] = reversed(nums[ind + 1:])

# Main function to test the solution
def main():
    sol = Solution()
    
    nums = [1, 2, 3]  # You can change this input to test other cases
    print("Original:", nums)
    
    sol.nextPermutation(nums)
    
    print("Next permutation:", nums)

if __name__ == "__main__":
    main()
