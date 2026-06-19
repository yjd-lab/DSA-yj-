class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char t : tasks){
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> used =
                new ArrayList<>();

            int cycle = n + 1;
            int work = 0;

            for(int i = 0;
                i < cycle && !pq.isEmpty();
                i++){

                int count = pq.poll();

                count--;

                work++;

                if(count > 0){
                    used.add(count);
                }
            }

            for(int c : used){
                pq.offer(c);
            }

            if(pq.isEmpty()){
                time += work;
            }
            else{
                time += cycle;
            }
        }

        return time;
    }
}