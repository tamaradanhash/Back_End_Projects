package com.example.tweeter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TwitterManager {
    private final TweetRepository repository;

    public List<Tweet> findAllTweets() {
        return repository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> findByUser(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }

    public Tweet save(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return repository.save(tweet);
    }

    public Tweet updateOneTweetWithExtraLike(String id) {
        Tweet tweet = repository.findById(id).orElse(null);
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        return repository.save(tweet);
    }

    public Tweet updateCommentsOfOneTweet(String id,String comment){
        Tweet tweet = repository.findById(id).orElse(null);
        tweet.getComments().add(comment);
        tweet.getComments();
        return repository.save(tweet);
    }

}
