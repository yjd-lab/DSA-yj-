class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        HashMap<Integer,  Integer> map = new HashMap<>();
        for(int i =0; i <nums1.length; i++){
            map.put(nums1[i],i);
        }
        for(int i =0 ;i< nums2.length; i++){
            int ch = nums2[i];
            while(!s.isEmpty() && ch > s.peek()){
                int temp = s.pop();
                int index = map.get(temp);
                result[index]= ch;
            }
            if (map.containsKey(ch)){
                s.push(ch);
            }
        }
        return result;
    }
}