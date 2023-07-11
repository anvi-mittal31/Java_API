package com.hus23.assignment.socialmediaplatform.Service;

import com.hus23.assignment.socialmediaplatform.Model.PostDetails;

import java.util.List;

public interface PostService {

    PostDetails createPost(PostDetails post);

    PostDetails updatePost(PostDetails post);

    List<PostDetails> getAllPosts();

    PostDetails getPostById(long PostID);

    List<PostDetails> searchByLocation(String Location);

    List<PostDetails> findPostsByUser(Long UserId);

    void deletePost(long id);

    PostDetails savePostForUser(PostDetails post, Long userId);

    void deletePostsByUser(Long userId);
}
