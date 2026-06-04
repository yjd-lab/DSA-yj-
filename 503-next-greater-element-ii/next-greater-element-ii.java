class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<2*nums.length;i++){
            int current = i% nums.length;
            while(!stk.isEmpty() && nums[current] > nums[stk.peek()]){
                int temp = stk.pop();
                result[temp] = nums[current]; 
            }
            if(i< nums.length){
                stk.push(current);
            }
        }
        return result;
    }
}