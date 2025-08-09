import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int end = nums1.length - 1; // last index of nums1

        while (m > 0 && n > 0) {
            if (nums2[n - 1] >= nums1[m - 1]) {
                nums1[end] = nums2[n - 1];
                n--;
            } else {
                nums1[end] = nums1[m - 1];
                m--;
            }
            end--;
        }

        while (n > 0) {
            nums1[end] = nums2[n - 1];
            n--;
            end--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before merge: " + Arrays.toString(nums1));
        obj.merge(nums1, m, nums2, n);
        System.out.println("After merge:  " + Arrays.toString(nums1));
    }
}
