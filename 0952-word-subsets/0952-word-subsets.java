import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) freq[c - 'a']++;
            for (int i = 0; i < 26; i++) maxFreq[i] = Math.max(maxFreq[i], freq[i]);
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) freq[c - 'a']++;
            if (isUniversal(freq, maxFreq)) result.add(word);
        }
        return result;
    }

    private boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) return false;
        }
        return true;
    }
}