class Solution {
    public char getMaxOccuringChar(String s) {

        int[] freq = new int[26];

        // Count frequency of each character.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int maxFreq = -1;
        char ans = 'a';

        // Find character with highest frequency.
        for (int i = 0; i < 26; i++) {

            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = (char) (i + 'a');
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna