class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        for(int i = 0 ; i< nums1.length ; i++){
            map.put(nums1[i],i);
        }
        for(int i =0 ; i< nums2.length; i++){
            while(!stk.isEmpty() && nums2[i] > stk.peek() ){
                int temp = stk.pop();
                int index = map.get(temp);
                result[index]= nums2[i];
            }
            if(map.containsKey(nums2[i])){
                stk.push(nums2[i]);
            }
        } return result;
    }
}