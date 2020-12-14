package com.example.cs5610finalprojectserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    private Integer customerId;
    private String title;
    private String entry;


    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Blog(Integer blogId, Integer customerId, String title, String entry) {
        this.blogId =blogId;
        this.customerId = customerId;
        this.title = title;
        this.entry = entry;
    }

    public Blog() {

    }

}
