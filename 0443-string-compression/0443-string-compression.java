class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < chars.length){
            char currentChar = chars[readIndex];
            int count = 0;
            // run untile dublicate chr found 
            while (readIndex < chars.length && currentChar == chars[readIndex]){
                readIndex++;
                count++;
            }
            // when count and current chr is present
            chars[writeIndex] = currentChar;
            writeIndex++;
            //now insert the count 
            if(count >1){
                String CountStr = String.valueOf(count);
                for (char digit : CountStr.toCharArray()){
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
            
        }
        // return the length of compressed string
        return writeIndex;   
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna