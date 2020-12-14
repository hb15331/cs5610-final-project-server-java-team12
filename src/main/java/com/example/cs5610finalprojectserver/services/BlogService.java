package com.example.cs5610finalprojectserver.services;


import com.example.cs5610finalprojectserver.models.Blog;
import com.example.cs5610finalprojectserver.models.Order;
import com.example.cs5610finalprojectserver.repositories.BlogRepository;
import com.example.cs5610finalprojectserver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> findAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    public List<Blog> findBlogForUser(Integer customerId) {
        return blogRepository.findBlogForUser(customerId);
    }

    public Blog creatBlog(Blog blog) {

        return blogRepository.save(blog);
    }
        public Blog updateBlog(
                Integer blogId,
                Blog newBlog) {
            Optional blogO = blogRepository.findById(blogId);
            if (blogO.isPresent()) {
                Blog blog = (Blog) blogO.get();
                blog.setTitle(newBlog.getTitle());
                blog.setEntry(newBlog.getEntry());
                return blogRepository.save(blog);
            } else {
                return null;
            }
        }

    public void deleteBlog(Integer bid) {
        blogRepository.deleteById(bid);
    }

}
