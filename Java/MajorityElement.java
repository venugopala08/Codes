import
 java.util.*;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        // Step 1: Create a HashMap to store element -> frequency
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        // Step 2: Count frequency of each element
        for (int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }

        // Step 3: Prepare a list to store results
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3; // An element must appear more than n/3 times

        // Step 4: Check which elements pass the threshold
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > threshold) {
                majorityElements.add(element);
            }
        }

        // Step 5: Return the list of majority elements
        return majorityElements;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println(sol.majorityElement(nums)); // Output: [3]
    }
}
