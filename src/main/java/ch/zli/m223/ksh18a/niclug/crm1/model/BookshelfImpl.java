package ch.zli.m223.ksh18a.niclug.crm1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Bookshelf")
public class BookshelfImpl implements Bookshelf {

	@Id
	@GeneratedValue
	private Long id;

	private String bookShelfName;

	@OneToMany(mappedBy = "bookshelf", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<BookImpl> books;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>(books);
	}

	/*
	 * public BookshelfImpl setBoooks(List<String> books) { this.books = new
	 * List<String>(books); return this; }
	 */

	@Override
	public Long getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getBookShelfName() {
		// TODO Auto-generated method stub
		return bookShelfName;
	}

}
