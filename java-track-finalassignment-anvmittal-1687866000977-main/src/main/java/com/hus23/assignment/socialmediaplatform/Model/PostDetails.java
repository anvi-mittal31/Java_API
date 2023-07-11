package com.hus23.assignment.socialmediaplatform.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="POSTS")
public class PostDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long PostId;

        @ManyToOne
        private UserDetails userDetails;

        @Column(name="time")
        private LocalDateTime createdAt;

        @PrePersist //indicates that the annotated method should be called before the entity is persisted (i.e., before it is saved to the database).
        public void prePersist() {

            createdAt = LocalDateTime.now();
        }

        @Column(name="location")
        private String Location;

        public UserDetails getUser() {
            return userDetails;
        }

        public void setUser(UserDetails user) {
            this.userDetails = user;
        }

        public Long getPostId() {
            return PostId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public void setPostId(Long postId) {
            PostId = postId;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String location) {
            Location = location;
        }
    }


