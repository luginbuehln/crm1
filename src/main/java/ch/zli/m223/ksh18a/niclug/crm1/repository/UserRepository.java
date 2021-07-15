package ch.zli.m223.ksh18a.niclug.crm1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.niclug.crm1.model.AppUser;
import ch.zli.m223.ksh18a.niclug.crm1.model.AppUserImpl;

public interface UserRepository extends CrudRepository<AppUserImpl, Long> {

	default AppUser insertUser(String userName, String password, List<String> roles) {
		AppUserImpl user = new AppUserImpl(userName, password, roles);
		return save(user);
	}

	Optional<AppUser> findByUserName(String userName);

	default AppUser setRoles(AppUser user, List<String> roles) {
		return save(((AppUserImpl) user).setRoles(roles));
	}
}
