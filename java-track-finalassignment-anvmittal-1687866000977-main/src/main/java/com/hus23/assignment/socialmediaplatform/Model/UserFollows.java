package com.hus23.assignment.socialmediaplatform.Model;

import javax.persistence.*;

@Entity
@Table(name="UserFollow")
public class UserFollows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserDetails follower;

    @ManyToOne
    @JoinColumn(name = "followed_id")
    private UserDetails followed;

    public UserFollows(UserDetails follower, UserDetails followed) {
    }
}
