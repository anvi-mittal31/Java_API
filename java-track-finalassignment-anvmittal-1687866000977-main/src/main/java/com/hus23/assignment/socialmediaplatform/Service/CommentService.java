package com.hus23.assignment.socialmediaplatform.Service;

import com.hus23.assignment.socialmediaplatform.Model.CommentDetails;

import java.util.List;

public interface CommentService {

    CommentDetails createComment(CommentDetails comment);

    CommentDetails updateComment(CommentDetails comment);

    List<CommentDetails> getAllComments();

    CommentDetails getCommentById(long commentID);

    void deleteComment(long id);
}
