package com.example.demo.controllers;

import com.example.demo.Services.CategoryService;
import com.example.demo.Services.PostService;
import com.example.demo.models.Category;
import com.example.demo.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.expression.Lists;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PostService service;
    @Autowired
    private CategoryService service_category;

    @GetMapping("")
    public String showPostList(Model model) {
        List<Post> listPosts = service.listAll();
        List<Category> listCategories = service_category.listAll();
        List<Post> newestPosts = service.listNewest();
        model.addAttribute("listPosts", listPosts);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("newestPosts", newestPosts);

        return "layouts/index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "layouts/login";
    }
    
    @GetMapping("/signup")
    public String showSignupPage() {
        return "layouts/signup";
    }

}
