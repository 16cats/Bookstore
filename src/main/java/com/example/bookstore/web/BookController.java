package com.example.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	// Rest all books http://localhost:8080/books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }  
	
	//get mapping is better than request here(?)
	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
		
		//for adding
	    @RequestMapping(value = "/add")
	    public String addBook(Model model){
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
	        return "addbook";
	    }     
	    
	    //for saving
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
			return "redirect:booklist";
	    }    
	    
	    //for editing
		@RequestMapping(value = "/edit/{id}")
		public String edit(@PathVariable("id") Long bookId, Model model){
			model.addAttribute("book", repository.findById(bookId));
			model.addAttribute("categories", crepository.findAll());
			return "editbook";
		}
	    
	    //for deleting
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			repository.deleteById(bookId);
			return "redirect:../booklist";
	    }     
	}