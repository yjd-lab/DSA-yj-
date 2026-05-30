class Solution {

    public String minWindow(String s, String t) {

        if(s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequencies of t
        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        // Number of characters still needed
        int required = t.length();

        // To store minimum window
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            // If character is needed
            if(map.containsKey(rightChar)) {

                // If frequency > 0, this char helps satisfy t
                if(map.get(rightChar) > 0) {
                    required--;
                }

                // Reduce frequency
                map.put(rightChar, map.get(rightChar) - 1);
            }

            // Window valid
            while(required == 0) {

                // Update minimum answer
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // If left char belongs to t
                if(map.containsKey(leftChar)) {

                    // Add back frequency
                    map.put(leftChar, map.get(leftChar) + 1);

                    // If frequency becomes > 0,
                    // we lost a required character
                    if(map.get(leftChar) > 0) {
                        required++;
                    }
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}