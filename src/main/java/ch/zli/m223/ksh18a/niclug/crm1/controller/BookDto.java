package ch.zli.m223.ksh18a.niclug.crm1.controller;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;

public class BookDto {
	public Long id;
	public final String bookName;

	public BookDto(Book book) {
		this.bookName = book.getBookName();
		this.id = book.getID();
	}
}
