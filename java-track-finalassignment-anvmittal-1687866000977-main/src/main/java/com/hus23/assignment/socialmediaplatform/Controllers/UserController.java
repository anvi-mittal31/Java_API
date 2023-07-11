package com.hus23.assignment.socialmediaplatform.Controllers;
import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import com.hus23.assignment.socialmediaplatform.Model.UserFollows;
import com.hus23.assignment.socialmediaplatform.Repository.UserFollowsRepository;
import com.hus23.assignment.socialmediaplatform.Repository.UserRespository;
import com.hus23.assignment.socialmediaplatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRespository userRepository;

     @Autowired
    private UserFollowsRepository userFollowsRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserDetails>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails user){
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PostMapping("/{followerId}/follow/{followedId}")
    public ResponseEntity<String> followUser(@PathVariable Long followerId, @PathVariable Long followedId) {
        Optional<UserDetails> followerOptional = userRepository.findById(followerId);
        Optional<UserDetails> followedOptional = userRepository.findById(followedId);

        if (followerOptional.isPresent() && followedOptional.isPresent()) {
            UserDetails follower = followerOptional.get();
            UserDetails followed = followedOptional.get();

            Optional<UserFollows> userFollowsOptional = userFollowsRepository.findByFollowerAndFollowed(follower, followed);

            if (userFollowsOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Already following");
            }

            UserFollows userFollows = new UserFollows(follower, followed);
            userFollowsRepository.save(userFollows);

            return ResponseEntity.ok("Successfully followed");
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{followerId}/unfollow/{followedId}")
    public ResponseEntity<String> unfollowUser(@PathVariable Long followerId, @PathVariable Long followedId) {
        Optional<UserDetails> followerOptional = userRepository.findById(followerId);
        Optional<UserDetails> followedOptional = userRepository.findById(followedId);

        if (followerOptional.isPresent() && followedOptional.isPresent()) {
            UserDetails follower = followerOptional.get();
            UserDetails followed = followedOptional.get();

            Optional<UserFollows> userFollowsOptional = userFollowsRepository.findByFollowerAndFollowed(follower, followed);

            if (userFollowsOptional.isPresent()) {
                UserFollows userFollows = userFollowsOptional.get();
                userFollowsRepository.delete(userFollows);

                return ResponseEntity.ok("Successfully unfollowed");
            }

            return ResponseEntity.badRequest().body("Not following");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/{firstName}")
    public ResponseEntity<List<UserDetails>> searchUserByFirstname(@PathVariable("firstName") String firstName) {
        List<UserDetails> users = this.userService.searchUserByUsername(firstName);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDetails> updateUsers(@PathVariable long id, @RequestBody UserDetails user){
        user.setUserId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @GetMapping("/search")
    public List<UserDetails> SearchByUserParameters(@PathVariable("username") String username,@PathVariable("firstName") String firstname, @PathVariable("lastName") String lastname){
        return userService.searchByUserParameters(username,firstname,lastname);
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUsers(@PathVariable Long id){
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }
}



