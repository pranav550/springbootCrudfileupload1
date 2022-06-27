package com.api.book.service;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {

@Autowired	
private BookRepository bookRepository;	
    
//private static List<Book> list = new ArrayList<>();
//
//static {
//	list.add(new Book(101,"Java Complete reference", "XYZ"));
//	list.add(new Book(102,"Head First to java", "ABC"));
//	list.add(new Book(103,"Thing in java", "PQR"));
//}

// get all Books
public List<Book> getAllBooks(){
	List<Book> list = (List<Book>)this.bookRepository.findAll();
	return list;
}

// get Sing book By id
public Book getBookById(int id) {
	Book book =null;
	try {
//		<!- book = list.stream().filter(e->e.getId()==id).findFirst().get(); ->	
		book = this.bookRepository.findById(id);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return book;
}

// adding the book 
public Book addBook(Book b) {
	//list.add(b);
	Book result = bookRepository.save(b);
	return result;
}

public void deleteBook(int bookId) {
//	list = list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
	bookRepository.deleteById(bookId);
}

public void updateBook(Book book, int bid) {
	System.out.println(book);
//	list =list.stream().map(b->{
//		if(b.getId()==bid) {
//			b.setTitle(book.getTitle());
//			b.setAuthor(book.getAuthor());
//		}
//		return b;
//	}).collect(Collectors.toList());
	
	book.setId(bid);
	bookRepository.save(book);
}
}
