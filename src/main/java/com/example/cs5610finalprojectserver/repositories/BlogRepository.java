package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.Blog;
import com.example.cs5610finalprojectserver.models.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Integer> {


    @Query("SELECT blog FROM Blog blog WHERE blog.customerId=:customerId")
    List<Blog> findBlogForUser(
            @Param("customerId") Integer customerId);

//    @Query("SELECT order FROM Order order WHERE order.delivererId=:delivererId")
//    List<Order> findOrderByDeliverer(
//            @Param("delivererId") Integer delivererId);

//@Query("SELECT order FROM Order order WHERE order.customerId=:customerId")
//     List<Order> findOrderForUser(
//            @Param("customerId") Integer customerId);
}
