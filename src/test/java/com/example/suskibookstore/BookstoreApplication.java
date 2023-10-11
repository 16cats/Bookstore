package com.example.suskibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.bookstore.domain.BookRepository;
//import com.example.bookstore.domain.Category;
//import com.example.bookstore.domain.CategoryRepository;
//import com.example.bookstore.domain.AppUser;
//import com.example.bookstore.domain.AppUserRepository;
import com.example.bookstore.domain.Book;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.bookstore.domain")
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	    return (args) -> {
	        // Create and save example categories
	        //Category category1 = crepository.save(new Category("Classics"));
	        //Category category2 = crepository.save(new Category("Fiction"));

	        // Create and save example books
	       // repository.save(new Book("Book 1", "Author 1", "ISBN1", 2022, 19.99, category1));
	       // repository.save(new Book("Book 2", "Author 2", "ISBN2", 2020, 24.99, category1));
	       // repository.save(new Book("Book 3", "Author 3", "ISBN3", 2021, 14.99, category2));
	    };
	}
}
