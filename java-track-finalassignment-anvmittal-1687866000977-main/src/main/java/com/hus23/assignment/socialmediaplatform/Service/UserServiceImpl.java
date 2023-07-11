package com.hus23.assignment.socialmediaplatform.Service;
import com.hus23.assignment.socialmediaplatform.Exception.ResourceNotFoundException;
import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import com.hus23.assignment.socialmediaplatform.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //indicates it is a service class and scan this class as a component scan
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails createUser(UserDetails user) {
        return userRespository.save(user);
    }

    @Override
    public UserDetails updateUser(UserDetails user) {

        Optional<UserDetails> userDB = this.userRespository.findById(user.getUserId());

        if(userDB.isPresent()) {
            UserDetails userUpdate = userDB.get();
            userUpdate.setUserId(user.getUserId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setBio(user.getBio());
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setPassword(user.getPassword());
            userRespository.save(userUpdate);
            return userUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + user.getUserId());
        }
    }

    @Override
    public List<UserDetails> getAllUsers() {

        return this.userRespository.findAll();
    }

    @Override
    public UserDetails getUserById(long userID) {

        Optional<UserDetails> userDB = this.userRespository.findById(userID);

        if(userDB.isPresent()){
            return userDB.get();
        }
        else{
            throw new ResourceNotFoundException("Record not found with id : " + userID);
        }
    }

    @Override
    public List<UserDetails> searchUserByUsername(String firstName) {
        return userRespository.findByUsernameContainingIgnoreCase(firstName);
    }

    //search-functionalities
    @Override
    public List<UserDetails> searchByUserParameters(String username,String lastName, String firstName){
        return userRespository.searchByUserParameters(username,firstName,lastName);
    }

    @Override
    public void deleteUser(long userID) {

        Optional<UserDetails> userDB = this.userRespository.findById(userID);

        if(userDB.isPresent()){
            this.userRespository.delete(userDB.get());
        }

        else{
            throw new ResourceNotFoundException("Record not found with id : " + userID);
        }

    }
}
