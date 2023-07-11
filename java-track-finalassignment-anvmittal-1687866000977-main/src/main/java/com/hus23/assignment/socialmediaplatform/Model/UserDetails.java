package com.hus23.assignment.socialmediaplatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
public class UserDetails {

    @JsonIgnore //ignores the existence of list : posts in postman
    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true) //orphan removal : deletion of post from database, when deleted by the user
    private List<PostDetails> posts = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;
    @Column(name = "username",  unique = true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="bio",length = 200)
    private String Bio;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
