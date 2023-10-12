package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	    return (args) -> {
	    	Book k1 = new Book("The Secret History", "Donna Tartt", "123456",1992,24.95);
	    	Book k2 = new Book("The Stranger", "Albert Camus", "654321",1942,19.95);
	    	Book k3 = new Book("Suuri Illusioni", "Mika Waltari", "123654",1928,10.95);
	    	
	    	repository.save(k1);
	    	repository.save(k2);
	    	repository.save(k3);
	    };
	}
}