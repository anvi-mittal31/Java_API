package com.hus23.assignment.socialmediaplatform.Service;
import com.hus23.assignment.socialmediaplatform.Exception.ResourceNotFoundException;
import com.hus23.assignment.socialmediaplatform.Model.CommentDetails;
import com.hus23.assignment.socialmediaplatform.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDetails createComment(CommentDetails comment) {

        return commentRepository.save(comment);
    }

    @Override
    public CommentDetails updateComment(CommentDetails comment) {

        Optional<CommentDetails> commentDB = this.commentRepository.findById(comment.getCommentId());

        if(commentDB.isPresent()) {
            CommentDetails commentUpdate = commentDB.get();
            commentUpdate.setCommentId(comment.getCommentId());
            commentUpdate.setMessage(comment.getMessage());
            commentUpdate.setDatetime(comment.getDatetime());
            commentRepository.save(commentUpdate);
            return commentUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + comment.getCommentId());
        }
    }

    @Override
    public List<CommentDetails> getAllComments() {

        return this.commentRepository.findAll();
    }

    @Override
    public CommentDetails getCommentById(long commentID) {

        Optional<CommentDetails> commentDB = this.commentRepository.findById(commentID);

        if(commentDB.isPresent()){
            return commentDB.get();
        }
        else{
            throw new ResourceNotFoundException("Record not found with id : " + commentID);
        }
    }

    @Override
    public void deleteComment(long commentID) {

        Optional<CommentDetails> commentDB = this.commentRepository.findById(commentID);

        if (commentDB.isPresent()) {
            this.commentRepository.delete(commentDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + commentID);
        }
    }


}
