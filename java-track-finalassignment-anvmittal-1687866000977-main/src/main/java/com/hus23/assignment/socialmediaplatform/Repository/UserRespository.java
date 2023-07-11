package com.hus23.assignment.socialmediaplatform.Repository;
import com.hus23.assignment.socialmediaplatform.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<UserDetails, Long> {

    @Query("FROM UserDetails as u WHERE LOWER(u.firstName) LIKE :firstName%")
    List<UserDetails> findByUsernameContainingIgnoreCase(@Param("firstName") String username);

    @Query("from UserDetails u WHERE u.username=:username and u.lastName=:lastName and u.firstName=:firstName")
    List<UserDetails> searchByUserParameters(@Param("username") String username,@Param("lastName") String lastName, @Param("firstName") String firstName);


}
