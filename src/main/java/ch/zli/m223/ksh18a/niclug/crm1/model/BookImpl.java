package ch.zli.m223.ksh18a.niclug.crm1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Book")
public class BookImpl implements Book {

	@Id
	@GeneratedValue
	private Long id;

	private String bookName;

	@ManyToOne
	public Bookshelf bookshelf;

	@ManyToOne
	public AppUser user;

	public BookImpl(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public Long getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getBookName() {
		// TODO Auto-generated method stub
		return bookName;
	}

}
