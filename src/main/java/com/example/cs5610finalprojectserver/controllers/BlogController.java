package com.example.cs5610finalprojectserver.controllers;


import com.example.cs5610finalprojectserver.models.Blog;
import com.example.cs5610finalprojectserver.models.Order;
import com.example.cs5610finalprojectserver.services.BlogService;
import com.example.cs5610finalprojectserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    BlogService service;

    @GetMapping("/api/blogs")
    public List<Blog> findAllOrders() {
        return service.findAllBlogs();
    }

    @GetMapping("/api/blogs/{cid}/blogs")
    public List<Blog> findBlogForUser(
            @PathVariable("cid") Integer customerId) {
        return service.findBlogForUser(customerId);
    }

    @PostMapping("/api/blogs")
    public Blog createOrder(@RequestBody Blog blog) {

        return service.creatBlog(blog);
    }

    @PutMapping("/api/blogs/{oid}")
    public Blog updateOrder(
            @PathVariable("oid") Integer orderId,
            @RequestBody Blog newBlog) {
        return service.updateBlog(orderId, newBlog);
    }

    @DeleteMapping("/api/blogs/{oid}")
    public void deleteOrder(
            @PathVariable("oid") Integer oid) {
        service.deleteBlog(oid);
    }

}
