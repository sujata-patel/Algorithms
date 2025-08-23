package sujata.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "gbarfoothefoobarhthbhnfoobar";
        String[] words = {"foo", "bar"};
        List<Integer> result = findSubstring(s, words);
        if (result != null) {
            for (int index : result) {
                System.out.print(index + " ");
            }
        } else {
            System.out.println("No valid substring found.");
        }
    }

    /**
     * barfoothefoobarman
     *
     */
    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || words.length == 0) {
            return res;
        }

        int wordLen = words[0].length();
        if(s.length() < wordLen * words.length) {
            return res;
        }

        // Count required words
        Map<String, Integer> wordCounts = new HashMap<>();
        Arrays.stream(words).forEach(word -> {wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);});

        for(int start=0; start < wordLen; start++) {
            int left = start, count = 0, right = start;
            Map<String, Integer> seenWords = new HashMap<>();

            for(;right <= s.length()-wordLen; right+=wordLen) {
                String word = s.substring(right, right+wordLen);

                if(wordCounts.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0)+1);
                    count++;

                    while(seenWords.get(word) > wordCounts.get(word)) {
                        String wordAtStart = s.substring(left, left+wordLen);
                        seenWords.put(word, seenWords.get(wordAtStart)-1);
                        left = left + wordLen;
                        count--;
                    }

                    if(count == words.length) {
                        res.add(left);
                        left += wordLen;
                        seenWords.clear();
                    }

                }else{
                    left = right + wordLen;
                    seenWords.clear();
                    count = 0;
                }
            }
        }

        return res;
    }
}
