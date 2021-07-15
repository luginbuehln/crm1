package ch.zli.m223.ksh18a.niclug.crm1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.niclug.crm1.model.AppUser;
import ch.zli.m223.ksh18a.niclug.crm1.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser user = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
		return user;
	}

}
