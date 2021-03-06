package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

  @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
  public User findUserByCredentials(
      @Param("username") String username,
      @Param("password") String password
  );


  @Query("SELECT user FROM User user WHERE user.username=:username")
  public User findUserByUsername(@Param("username") String username);


  @Query(value = "SELECT * FROM users", nativeQuery = true)
  public List<User> findAllUsers();

  @Query("SELECT user FROM User user WHERE user.location=:location AND user.type=:type")
  public List<User> findMatchingDeliverers(
          @Param("location") String location,
          @Param("type") String type
  );


}
