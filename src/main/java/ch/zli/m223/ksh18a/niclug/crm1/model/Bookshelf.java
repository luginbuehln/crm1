package ch.zli.m223.ksh18a.niclug.crm1.model;

import java.util.List;

public interface Bookshelf {

	List<Book> getBooks();

	Long getID();

	String getBookShelfName();
}
