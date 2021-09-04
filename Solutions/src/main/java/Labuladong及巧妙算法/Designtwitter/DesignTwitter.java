package Labuladong及巧妙算法.Designtwitter;

import java.util.*;

public class DesignTwitter {
    private int timestamp = 0;

    private class Tweet {
        int id;
        int ttp;
        Tweet next;

        public Tweet(int id, int ttp) {
            this.id = id;
            this.ttp = ttp;
        }
    }

    private class User {
        private int id;
        private HashSet<Integer> followed = new HashSet<>();
        private Tweet head = null;

        public User(int id) {
            this.id = id;
            followed.add(id);
        }

        public void follow(int uid) {
            followed.add(uid);
        }

        public void post(int tid) {
            Tweet twt = new Tweet(tid, timestamp++);
            twt.next = head;
            head = twt;
        }

        public void unfollow(int uid) {
            if (uid != id) followed.remove(uid);
        }
    }

    private HashMap<Integer, User> userMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public DesignTwitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> r = new ArrayList<>();
        if (!userMap.containsKey(userId)) return r;
        HashSet<Integer> set = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(set.size(), (x, y) -> -1 * (x.ttp - y.ttp));
        for (int k : set){
            Tweet head = userMap.get(k).head;
            if(head!=null)
            priorityQueue.add(head);
        }
        while (!priorityQueue.isEmpty()) {
            Tweet twt = priorityQueue.poll();
            r.add(twt.id);
            if (r.size() == 10) break;
            if (twt.next != null) priorityQueue.offer(twt.next);
        }
        return r;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId))
            userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter tw = new DesignTwitter();
        tw.postTweet(1, 1);
        System.out.println(tw.getNewsFeed(1));
        tw.follow(2, 1);
        System.out.println(tw.getNewsFeed(2));
        tw.unfollow(2, 1);
        System.out.println(tw.getNewsFeed(2));
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */