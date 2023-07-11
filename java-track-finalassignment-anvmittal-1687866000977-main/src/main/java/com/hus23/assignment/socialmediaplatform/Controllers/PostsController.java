package com.hus23.assignment.socialmediaplatform.Controllers;

import com.hus23.assignment.socialmediaplatform.Model.PostDetails;
import com.hus23.assignment.socialmediaplatform.Repository.PostRepository;
import com.hus23.assignment.socialmediaplatform.Service.PostService;
import com.hus23.assignment.socialmediaplatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity<List<PostDetails>> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @DeleteMapping("/posts/{userId}")
    public ResponseEntity<String> deletePostsByUser(@PathVariable Long userId) {
        postService.deletePostsByUser(userId);
        return ResponseEntity.ok("All posts of the user with ID " + userId + " have been deleted.");
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDetails> getPostsById(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.getPostById(id));
    }

    @GetMapping("posts/search/{location}")
    public List<PostDetails> searchByLocation(@PathVariable("location") String location){
        return postService.searchByLocation(location);
    }

    @PostMapping("/posts/{userId}")
    public ResponseEntity<PostDetails> savePostForUser(@RequestBody PostDetails post, @PathVariable Long userId) {
        PostDetails savedPost = postService.savePostForUser(post, userId);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("/users/{userId}/posts")
    public List<PostDetails> findPostsByUser(@PathVariable("userId") Long userId) {
        return postService.findPostsByUser(userId);
    }


    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDetails> updatePosts(@PathVariable long id, @RequestBody PostDetails post){
        post.setPostId(id);
        return ResponseEntity.ok().body(this.postService.updatePost(post));
    }

    @DeleteMapping("/posts/deleteByPostID/{id}")
    public HttpStatus deletePost(@PathVariable long id){
        this.postService.deletePost(id);
        return HttpStatus.OK;
    }

}
