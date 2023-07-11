package com.hus23.assignment.socialmediaplatform.Service;

import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import com.hus23.assignment.socialmediaplatform.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    UserDetails createUser(UserDetails user);

    UserDetails updateUser(UserDetails user);

    List<UserDetails> getAllUsers();

    UserDetails getUserById(long userID);

    //search-functionalities
    List<UserDetails> searchByUserParameters(String username, String lastName, String firstName);

    void deleteUser(long id);

    List<UserDetails> searchUserByUsername(String firstName);

//    List<UserDetails> searchByUserParameters(String username);
//
//    List<UserDetails> searchByLastname(String lastName);
//
//    List<UserDetails> searchByFirstname(String firstName);

}
