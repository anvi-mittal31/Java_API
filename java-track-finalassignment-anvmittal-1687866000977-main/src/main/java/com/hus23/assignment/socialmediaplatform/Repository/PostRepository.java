package com.hus23.assignment.socialmediaplatform.Repository;

import com.hus23.assignment.socialmediaplatform.Model.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<PostDetails, Long> {

    @Query("from PostDetails as p where p.Location= :Location")
    List<PostDetails> searchByLocation(@Param("Location") String location);

    @Query("from PostDetails as p where p.userDetails.UserId =:UserId")
    public List<PostDetails> findPostsByUser(@Param("UserId") Long UserId);

    @Modifying
    @Query("DELETE FROM PostDetails p WHERE p.userDetails.UserId = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
