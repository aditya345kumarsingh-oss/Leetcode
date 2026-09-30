class Solution {
    public String removeOccurrences(String s, String part) {
        //kab tak same 2 steps krege
        //jab tak part exist karta h s string me 

        while(s.contains(part)){
            // search part inside s
             int index = s.indexOf(part);

            //create a new string by merging the left and right part of donund substring
            s = s.substring(0,index) + s.substring(index + part.length());

        }
        return s;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna