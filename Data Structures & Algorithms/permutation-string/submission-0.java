class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // to achieve O(n) time, consider find frequencies of char in pattern & match w/ sections in s2, kinda like rabin karp 
        // windows to check is bigger string length - smaller string length + 1, mapping indices by (char to check - 'a')
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        // finding num matches O(1) because O(26)
        int matching = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) {
                matching++;
            }
        }
        // sliding window
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matching == 26) {
                return true;
            }
            // adding new char (end new window)
            int add = s2.charAt(i + s1.length()) - 'a';
            if (windowCount[add] == s1Count[add]) {
                matching--; // if it was matching, about to break w/ transition
            }
            windowCount[add]++;
            if (windowCount[add] == s1Count[add]) {
                matching++;
            }
            // remove old char (beginning of old window)
            int remove = s2.charAt(i) - 'a';
            if (windowCount[remove] == s1Count[remove]) {
                matching--;
            }
            windowCount[remove]--;
            if (windowCount[remove] == s1Count[remove]) {
                matching++;
            }
        }
        return matching == 26;
    }
}
