package com.example.tweeter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TwitterEndpoint {

    private final TwitterManager manager;

    @GetMapping
    List<Tweet> get() {
        return manager.findAllTweets();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getUserTweets(@PathVariable String user) {
        return manager.findByUser(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {
        return manager.save(tweet);
    }

    @PutMapping("/{id}/likes")
    Tweet putToLikes(@PathVariable String id){
        return manager.updateOneTweetWithExtraLike(id);
    }

    @PutMapping("/{id}/comments")
    Tweet putToComments(@PathVariable String id,@RequestBody String comments){
        return manager.updateCommentsOfOneTweet(id,comments);
    }
}

//    GET to /tweets -> returns all Tweets ordered by timestamp descending.
//        GET to /tweets/user/{user} -> returns all Tweets of user ordered by timestamp descending
//        POST a Tweet to /tweets -> saves new Tweet. The app sets the timestamp of the Tweet right before saving it.
//        PUT to /tweets/{id}/likes -> adds one like to the Tweet with id.
//        PUT to /tweets/{id}/comments -> adds to the Tweet with id one comment received via request body.
