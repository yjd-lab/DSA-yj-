class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {

            m1.put(s1.charAt(i),
            m1.getOrDefault(s1.charAt(i), 0) + 1);

            m2.put(s2.charAt(i),
            m2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(m1.equals(m2)) {
            return true;
        }

        int j = 0;

        for(int i = s1.length(); i < s2.length(); i++) {

            char leftChar = s2.charAt(j);

            m2.put(leftChar,
            m2.get(leftChar) - 1);

            if(m2.get(leftChar) == 0) {
                m2.remove(leftChar);
            }

            m2.put(s2.charAt(i),
            m2.getOrDefault(s2.charAt(i), 0) + 1);

            j++;

            if(m1.equals(m2)) {
                return true;
            }
        }

        return false;
    }
}
/* 
class Solution {
    static {
        for(int i=0;i<500;i++){
            checkInclusion("ab","ababab");
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (match(freq1, freq2))
            return true;

        for (int i = n1; i < n2; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n1) - 'a']--;

            if (match(freq1, freq2)) return true;
        }

        return false;
    }

    public static boolean match(int[] a,int[] b){

        for(int i=0;i<26;i++){
            if(a[i]!=b[i])return false;
        }

        return true;
    }
}
*/