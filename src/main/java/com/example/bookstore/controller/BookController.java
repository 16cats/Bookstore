package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/index")
    public String index(Model model) {

    	List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());

        model.addAttribute("books", books);
        return "index";
    }
}
