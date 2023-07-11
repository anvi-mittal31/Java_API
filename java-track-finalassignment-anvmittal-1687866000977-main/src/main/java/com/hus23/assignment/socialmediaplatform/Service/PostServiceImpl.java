package com.hus23.assignment.socialmediaplatform.Service;

import com.hus23.assignment.socialmediaplatform.Exception.ResourceNotFoundException;
import com.hus23.assignment.socialmediaplatform.Model.PostDetails;
import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import com.hus23.assignment.socialmediaplatform.Repository.PostRepository;
import com.hus23.assignment.socialmediaplatform.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRespository;

    @Autowired
    private UserRespository userRespository;

    @Override
    public PostDetails createPost(PostDetails post) {

        return postRespository.save(post);
    }

    @Override
    @Transactional
    public void deletePostsByUser(Long userId) {
        postRespository.deleteByUserId(userId);
    }


    @Override
    public PostDetails updatePost(PostDetails post) {

        Optional<PostDetails> postDB = this.postRespository.findById(post.getPostId());

        if(postDB.isPresent()) {
            PostDetails postUpdate = postDB.get();
            postUpdate.setPostId(post.getPostId());
            postUpdate.setLocation(post.getLocation());
            postUpdate.setCreatedAt(post.getCreatedAt());
            postRespository.save(postUpdate);
            return postUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + post.getPostId());
        }
    }

    @Override
    public PostDetails savePostForUser(PostDetails post, Long userId) {
        UserDetails user = userRespository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        post.setUser(user);
        return postRespository.save(post);
    }
    @Override
    public List<PostDetails> getAllPosts() {

        return this.postRespository.findAll();
    }

    @Override
    public PostDetails getPostById(long postID) {

        Optional<PostDetails> postDB = this.postRespository.findById(postID);

        if (postDB.isPresent()) {
            return postDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + postID);
        }
    }

    public List<PostDetails> searchByLocation(String loc){
        return postRespository.searchByLocation(loc);
    }

    public List<PostDetails> findPostsByUser(Long UserId){
        return postRespository.findPostsByUser(UserId);
    }

    @Override
    public void deletePost(long postID) {

        Optional<PostDetails> postDB = this.postRespository.findById(postID);

        if (postDB.isPresent()) {
            this.postRespository.delete(postDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + postID);
        }
    }

}
