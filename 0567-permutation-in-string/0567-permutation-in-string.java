class Solution {
    static boolean compareFreq(int[]count1,int[]count2){
        for(int i=0; i<26; i++){
            if (count1[i]!= count2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        //check whether s1 k character are present or not in s2
        //s1 ka table ready kar lete h
        //s2 ki 1st window ko process kar lete hai
        //then remaing s2 will ko process karo 

        if(s1.length()>s2.length()){
            return false;
        }
        int count1[]=new int [26];
        for (int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }
        int i=0;
        int windowlength = s1.length();
        int count2[]=new int [26];

        //first window ka freq table
        for(i=0 ; i<windowlength; i++){
            char ch =s2.charAt(i);
            int index = ch- 'a';
            count2[index]++;
        }
        if (compareFreq(count1,count2)==true){
            return true;
        }
        else {
            //if not match
            //process remainging window
            while (i<s2.length()){
                //to find the new character and add in freq table 
                char newChar = s2.charAt(i);
                int newCharIndex = newChar - 'a';
                count2[newCharIndex]++;

                //to find the old character index and remove 
                int oldCharIndex = i-windowlength;
                char oldChar = s2.charAt(oldCharIndex);
                int freqTableIndexOfOldChar = oldChar -'a';
                count2[freqTableIndexOfOldChar]--;
                //compare 
                //if not s1 match do first value 0 and next 1
                if (compareFreq(count1, count2)== true)
                return true;
                i++;


            }

        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna