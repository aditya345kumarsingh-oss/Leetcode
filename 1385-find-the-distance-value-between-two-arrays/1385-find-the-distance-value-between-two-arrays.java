import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            if (isValid(arr2, x - d, x + d)) {
                count++;
            }
        }

        return count;
    }

    // Returns true if NO element in arr2 falls in [low, high]
    private boolean isValid(int[] arr2, int low, int high) {
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] >= low && arr2[mid] <= high) {
                return false; // Found an element within distance d
            } else if (arr2[mid] < low) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna