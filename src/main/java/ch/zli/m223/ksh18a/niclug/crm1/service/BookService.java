package ch.zli.m223.ksh18a.niclug.crm1.service;

import java.util.List;

import ch.zli.m223.ksh18a.niclug.crm1.model.Book;

public interface BookService {

	List<Book> getAllBook();

	Book addUser(String userName);

	Book findByUserName(String userName);

	Book getUserById(long userId);

	void deleteUserById(long userId);
}
