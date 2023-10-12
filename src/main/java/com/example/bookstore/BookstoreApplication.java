package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	    return (args) -> {
	    	
	    	crepository.save(new Category("Fiction"));
	    	crepository.save(new Category("Classics"));
	    	crepository.save(new Category("Finnish"));
	    	
			repository.save(new Book("The Secret History","Donna Tartt","123456",1992,19.95,crepository.findByName("Fiction").get(0)));
			repository.save(new Book("The Stranger","Albert Camus","654321",1942,19.95,crepository.findByName("Classics").get(0)));
			repository.save(new Book("Suuri Illusioni","Mika Waltari","000000",1928,19.95,crepository.findByName("Finnish").get(0)));

	    };
	}
}