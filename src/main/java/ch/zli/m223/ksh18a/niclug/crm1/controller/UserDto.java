package ch.zli.m223.ksh18a.niclug.crm1.controller;

import java.util.List;

import ch.zli.m223.ksh18a.niclug.crm1.model.AppUser;
import ch.zli.m223.ksh18a.niclug.crm1.model.Book;

public class UserDto {
	public Long id;
	public final String userName;
	public List<String> roles;
	public List<Book> books;

	public UserDto(AppUser user) {
		this.id = user.getID();
		this.userName = user.getUsername();
		this.roles = user.getRoles();
		this.books = user.getBooks();
	}

}
