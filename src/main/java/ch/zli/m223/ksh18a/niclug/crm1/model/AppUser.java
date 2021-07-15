package ch.zli.m223.ksh18a.niclug.crm1.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails {

	Long getID();

	public List<String> getRoles();

	public List<Book> getBooks();
}
