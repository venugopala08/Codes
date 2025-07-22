
import java.util.Arrays;


class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;

        for(int i = n-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
           reverse(nums,0,n-1);
           return;
        }

        for(int i = n-1 ; i >= ind ; i--){
            if(nums[ind]< nums[i]){
                swap(nums,ind,i);
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }

    void swap(int []nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int [] nums, int start,int end){

        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }  
}


public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 1, 3};  // You can change this input to test other cases
        System.out.println("Original: " + Arrays.toString(nums));

        solution.nextPermutation(nums);

        System.out.println("Next permutation: " + Arrays.toString(nums));
    }
}