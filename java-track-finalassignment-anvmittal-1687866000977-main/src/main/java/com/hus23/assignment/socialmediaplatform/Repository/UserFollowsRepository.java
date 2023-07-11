package com.hus23.assignment.socialmediaplatform.Repository;

import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import com.hus23.assignment.socialmediaplatform.Model.UserFollows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFollowsRepository extends JpaRepository<UserFollows,Long> {

    Optional<UserFollows> findByFollowerAndFollowed(UserDetails follower, UserDetails followed);


}
