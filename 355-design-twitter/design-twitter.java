class Twitter {

    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(
            userId,
            new ArrayList<>()
        );

        tweetMap.get(userId)
                .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
            );

        Set<Integer> users =
            new HashSet<>();

        users.add(userId);

        if (followMap.containsKey(userId)) {
            users.addAll(
                followMap.get(userId)
            );
        }

        for (int user : users) {

            if (!tweetMap.containsKey(user))
                continue;

            for (int[] tweet :
                 tweetMap.get(user)) {

                pq.offer(tweet);
            }
        }

        List<Integer> feed =
            new ArrayList<>();

        while (!pq.isEmpty()
            && feed.size() < 10) {

            feed.add(
                pq.poll()[1]
            );
        }

        return feed;
    }

    public void follow(
        int followerId,
        int followeeId
    ) {

        followMap.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        followMap.get(followerId)
                 .add(followeeId);
    }

    public void unfollow(
        int followerId,
        int followeeId
    ) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId)
                     .remove(followeeId);
        }
    }
}