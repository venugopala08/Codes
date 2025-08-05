import java.util.Arrays;

public class SortColours {

    // Method to sort the array using Dutch National Flag Algorithm
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // nums[mid] == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Original array: " + Arrays.toString(nums));

        sortColors(nums);

        System.out.println("Sorted array:   " + Arrays.toString(nums));
    }
}


// Another method
/* 
class Solution {
    public void sortColors(int[] nums) {

        int count = 0;
        int count1 = 0;
        int  count2 = 0; 
        for (int i = 0 ; i<nums.length; i++){
            if (nums [i] == 0)
                count++;
            else if (nums[i] == 1)
                count1++;
            else 
                count2++;
        }
        for(int i=0;i<count;i++)
            nums[i] = 0;
        for(int i=count;i<count+count1;i++)
            nums[i] = 1;
        for(int i=count+count1;i<nums.length;i++)
            nums[i] = 2;
    }
}

*/