class Solution {
    public String longestPalindrome(String s) {
        int length = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd length
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    index = left;
                    length = right - left + 1;
                }
                left--;
                right++;
            }
            // even length (diff right bound)
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    index = left;
                    length = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return s.substring(index, index + length);
    }
}
