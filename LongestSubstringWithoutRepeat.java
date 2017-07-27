/* Longest Substring Without Repeat */
/*
 * Given a string, 
 * find the length of the longest substring without repeating characters.
 */

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<Character>();

        int maxLen = 0;
        int start = 0;

        for (int i=0; i<A.length(); i++) {
            char cur = A.charAt(i);
            if (!set.contains(cur)) {
                set.add(cur);
            }
            else {
                maxLen = Math.max(maxLen, set.size());

                for (int j=start; j<i; j++) {
                    set.remove(A.charAt(j));
                }
                start++;
                i = start - 1;
            }
        }

        maxLen = Math.max(maxLen, set.size());

        return maxLen;
    }
}

