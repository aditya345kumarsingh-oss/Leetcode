import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // set.add() returns false if the element already exists
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}