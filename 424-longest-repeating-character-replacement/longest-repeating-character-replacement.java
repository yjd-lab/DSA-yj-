class Solution {

    public int characterReplacement(String s, int k) {

        int i = 0;
        int result = 0;
        int maxfreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            map.put(ch,
            map.getOrDefault(ch, 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(ch));

            while((j - i + 1) - maxfreq > k) {

                char leftChar = s.charAt(i);

                map.put(leftChar,
                map.get(leftChar) - 1);

                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}