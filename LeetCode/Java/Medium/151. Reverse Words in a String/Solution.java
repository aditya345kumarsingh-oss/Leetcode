class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // remove trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // if no word is left
            if (i < 0) {
                break;
            }

            int j = i;

            // find starting index of current word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // add current word
            ans.append(s.substring(j + 1, i + 1));

            // remove extra spaces before next word
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // add one space if more words are left
            if (j >= 0) {
                ans.append(' ');
            }

            // move i to remaining part
            i = j;
        }

        return ans.toString();
    }
}