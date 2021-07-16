package ch.zli.m223.ksh18a.niclug.crm1.service;

import java.util.List;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;

public interface BookService {
	List<Book> getAllBooks();

	Book addBook(String bookName);

	Book findByBookName(String bookName);

	Book getBookById(long bookId);

	void deleteBookById(long bookId);

}
