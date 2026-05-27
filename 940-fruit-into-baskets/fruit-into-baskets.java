class Solution {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int res = 0;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int right = 0; right < fruits.length; right++) {

            count.put(fruits[right],
            count.getOrDefault(fruits[right], 0) + 1);

            while(count.size() > 2) {

                int leftFruit = fruits[left];

                count.put(leftFruit,
                count.get(leftFruit) - 1);

                if(count.get(leftFruit) == 0) {
                    count.remove(leftFruit);
                }

                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}