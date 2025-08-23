package sujata.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoReapeatingChar {

    public static void main(String[] args) {
        String s = "hgkjagdjgjjjjjkhajcgj";
        int res = longestSubString(s);
        System.out.println(res);
        System.out.println(""+(res == 6));
    }

    private static int longestSubString(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;
        for(;right<s.length(); right++) {
            char c = s.charAt(right);
            if(seen.containsKey(c) && seen.get(c) >= left) {
                left = seen.get(c) + 1;
            }

            seen.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
