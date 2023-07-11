package com.hus23.assignment.socialmediaplatform.Controllers;

import com.hus23.assignment.socialmediaplatform.Model.CommentDetails;
import com.hus23.assignment.socialmediaplatform.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDetails>> getAllComments(){
        return ResponseEntity.ok().body(this.commentService.getAllComments());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDetails> getCommentById(@PathVariable long id){
        return ResponseEntity.ok().body(this.commentService.getCommentById(id));
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDetails> createComment(@RequestBody CommentDetails comment){
        return ResponseEntity.ok().body(this.commentService.createComment(comment));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentDetails> updateComments(@PathVariable long id, @RequestBody CommentDetails comment){
        comment.setCommentId(id);
        return ResponseEntity.ok().body(this.commentService.updateComment(comment));
    }

    @DeleteMapping("/comments/{id}")
    public HttpStatus deleteComment(@PathVariable long id){
        this.commentService.deleteComment(id);
        return HttpStatus.OK;
    }

}
