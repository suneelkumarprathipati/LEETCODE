class Solution {
    public int maxFrequency(int[] nums, int k) {
        countingSort(nums); // Sort the array using counting sort
        int start = 0; // Start index of the current subarray
        int subarraySum = 0; // Sum of elements in the current subarray
        int maxFrequency = 1; // Initialize the maximum frequency to 1

        // Iterate through the sorted array
        for (int i = 0; i < nums.length; i++) {
            int subarrayLength = i - start + 1; // Length of the current subarray
            int subarrayProduct = nums[i] * subarrayLength; // Product of element and subarray length
            subarraySum += nums[i]; // Add the current element to the subarray sum

            // Adjust the subarray to satisfy the condition (product - sum <= k)
            while (subarrayProduct - subarraySum > k) {
                subarraySum -= nums[start]; // Remove the leftmost element from the subarray
                start++; // Move the start index to the right
                subarrayLength--; // Decrease the length of the subarray
                subarrayProduct = nums[i] * subarrayLength; // Recalculate the product
            }

            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, subarrayLength);
        }

        return maxFrequency; // Return the final result
    }

    // Counting Sort to sort the array in non-decreasing order
    private void countingSort(int[] nums) {
        int maxElement = Integer.MIN_VALUE;

        // Find the maximum element in the array
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        // Create an array to store the count of each element
        int[] countMap = new int[maxElement + 1];

        // Count the occurrences of each element in the array
        for (int num : nums) {
            countMap[num]++;
        }

        int index = 0;

        // Reconstruct the sorted array
        for (int i = 0; i <= maxElement; i++) {
            while (countMap[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}