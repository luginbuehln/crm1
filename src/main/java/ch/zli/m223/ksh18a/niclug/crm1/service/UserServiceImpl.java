package ch.zli.m223.ksh18a.niclug.crm1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.niclug.crm1.exception.InvalidArgumentException;
import ch.zli.m223.ksh18a.niclug.crm1.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh18a.niclug.crm1.exception.UserNotFoundException;
import ch.zli.m223.ksh18a.niclug.crm1.model.AppUser;
import ch.zli.m223.ksh18a.niclug.crm1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRerpository;

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> res = new ArrayList<>();

		for (var user : userRerpository.findAll()) {
			res.add(user);
		}
		return res;
	}

	@Override
	public AppUser addUser(String userName, String password, List<String> roles) {
		// TODO Check parameter
		if (userName == null || password == null) {
			throw new InvalidArgumentException();
		}
		// Check already exists
		if (userRerpository.findByUserName(userName).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		// TODO Test if user already exists
		return userRerpository.insertUser(userName, password, roles == null ? new ArrayList<>() : roles);
	}

	@Override
	public AppUser findByUserName(String userName) {
		if (userName == null) {
			throw new UserNotFoundException();
		}
		return userRerpository.findByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public AppUser getUserById(long userid) {
		return userRerpository.findById(userid).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public void deleteUserById(long userId) {
		getUserById(userId);
		userRerpository.deleteById(userId);
	}

	@Override
	public AppUser setRolesForUser(long userId, List<String> roles) {
		if (roles == null) {
			throw new InvalidArgumentException();
		}
		AppUser user = getUserById(userId);
		return userRerpository.setRoles(user, roles);
	}

}
