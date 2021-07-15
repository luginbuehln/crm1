package ch.zli.m223.ksh18a.niclug.crm1.repository;

import java.util.Optional;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;
import ch.zli.m223.ksh18a.niclug.crm1.model.BookImpl;

public interface BookRepository {

	default Book insertBook(String bookName) {
		BookImpl book = new BookImpl(bookName);
		return book;
	}

	Optional<Book> findByUserName(String bookName);
}
