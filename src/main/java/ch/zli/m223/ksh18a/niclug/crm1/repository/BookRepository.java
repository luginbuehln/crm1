package ch.zli.m223.ksh18a.niclug.crm1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;
import ch.zli.m223.ksh18a.niclug.crm1.model.BookImpl;

public interface BookRepository extends CrudRepository<BookImpl, Long> {

	default Book insertBook(String bookName) {
		BookImpl book = new BookImpl(bookName);
		return book;
	}

	Optional<Book> findByBookName(String bookName);

	/*
	 * default Bookshelf setBooks(Bookshelf bookshelf, List<String> books) { return
	 * save(((BookshelfImpl) bookshelf).setBooks(books)); }
	 */
}
