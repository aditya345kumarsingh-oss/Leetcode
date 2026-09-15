class Solution {
    public int search(int[] nums, int target) {
         int left = 0;
        int right = nums.length - 1;
       

        while (left <= right) {
            int mid = left + (right - left) / 2;
            

            // Check if the target is present at mid
            if (nums[mid] == target) {
                return mid; // Target found
            }

            // If target is greater, ignore the left half
            if (nums[mid] < target) {
                left = mid + 1;
            } else { // If target is smaller, ignore the right half
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }}

        
    