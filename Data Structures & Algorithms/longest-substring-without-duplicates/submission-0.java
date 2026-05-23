class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> occurrence = new HashMap<>();
        int length = 0;
        int lengthString = 0;
        for (int i = 0; i < s.length(); i++) {
            if (occurrence.containsKey(s.charAt(i))) {
                length = Math.max(occurrence.get(s.charAt(i)) + 1, length);
            }
            occurrence.put(s.charAt(i), i);
            lengthString = Math.max(lengthString, i - length + 1);
        }
        return lengthString;
    }
}
