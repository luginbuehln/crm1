package ch.zli.m223.ksh18a.niclug.crm1.controller;

import java.util.List;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;
import ch.zli.m223.ksh18a.niclug.crm1.model.Bookshelf;

public class BookshelfDto {
	public Long id;
	public final String bookShelfName;
	public List<Book> books;

	public BookshelfDto(Bookshelf bookshelf) {
		this.id = bookshelf.getID();
		this.bookShelfName = bookshelf.getBookShelfName();
		this.books = bookshelf.getBooks();
	}

}
