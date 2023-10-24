class Tweet{
    int userId;
    int tweetId;
    int timeStamp;

    Tweet(int u, int t, int ts){
        this.userId = u;
        this.tweetId = t;
        this.timeStamp = ts;
    }
}

class Twitter {

    ArrayList<Integer> users;
    HashMap<Integer, ArrayList<Integer>> followers;
    HashMap<Integer, ArrayList<Tweet>> feed;
    int time = 1;


    public Twitter() {
        users = new ArrayList<>();
        followers = new HashMap<>();  
        feed = new HashMap<>();  
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId,tweetId,time++);
        ArrayList<Tweet> tweets;
        if(feed.containsKey(userId))
            tweets = feed.get(userId);
        else
            tweets = new ArrayList<Tweet>();
        tweets.add(tweet);
        feed.put(userId,tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        ArrayList<Integer> followingList = followers.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.timeStamp-a.timeStamp);
        for(Map.Entry<Integer,ArrayList<Tweet>> entry : feed.entrySet()){
            if(entry.getKey() == userId){
                ArrayList<Tweet> user_tweets = entry.getValue();
                for(Tweet each_tweet_by_user: user_tweets)
                    pq.add(each_tweet_by_user);
            }
            if(followingList!=null && followingList.contains(entry.getKey())){
                ArrayList<Tweet> following_tweets = entry.getValue();
                for(Tweet each_tweet_by_followee: following_tweets)
                    pq.add(each_tweet_by_followee);
            }
        }
        int c = 0;
        List<Integer> newsFeed = new ArrayList<>();
        while(pq.size()>0){
            Tweet tweet = pq.poll();
            newsFeed.add(tweet.tweetId);
            c++;
            if(c==10)
                break;
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        ArrayList<Integer> followingList;
        if(followers.containsKey(followerId)){
            followingList = followers.get(followerId);
        }
        else{
            followingList = new ArrayList<>();
        }
        followingList.add(followeeId);
        followers.put(followerId,followingList);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            ArrayList<Integer> followingList  = followers.get(followerId);
            followingList.remove(followingList.indexOf(followeeId));
            followers.put(followerId,followingList);
        }
    }
}