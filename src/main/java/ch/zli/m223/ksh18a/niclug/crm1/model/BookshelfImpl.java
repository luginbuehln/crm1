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
	public List<Book> books;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>(books);
	}

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
