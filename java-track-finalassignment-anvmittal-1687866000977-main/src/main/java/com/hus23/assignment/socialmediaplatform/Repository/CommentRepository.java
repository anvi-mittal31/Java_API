package com.hus23.assignment.socialmediaplatform.Repository;

import com.hus23.assignment.socialmediaplatform.Model.CommentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<CommentDetails, Long> {
}
