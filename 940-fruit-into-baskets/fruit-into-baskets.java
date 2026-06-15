class Solution {
    public int totalFruit(int[] fruits) {
        int j =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i =0;i<fruits.length;i++){
            int ch = fruits[i];
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>2){
                map.put(fruits[j],map.get(fruits[j])-1);
                if(map.get(fruits[j])==0){
                    map.remove(fruits[j]);
                }
                j++;
            }
            res=Math.max(res,i-j+1);
            
        }
        return res;
    }
}