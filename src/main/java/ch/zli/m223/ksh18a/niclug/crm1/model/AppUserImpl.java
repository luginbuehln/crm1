package ch.zli.m223.ksh18a.niclug.crm1.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
@Entity(name = "User")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue
	private Long id;

	private String userName;
	private String passwordHash;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Book> books;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles;

	public AppUserImpl(String userName, String password, List<String> roles) {
		this.userName = userName;
		setPassword(password);
		this.roles = new HashSet<>(roles);
	}

	protected AppUserImpl() {
	} // for JPA only

	public AppUserImpl setRoles(List<String> roles) {
		this.roles = new HashSet<>(roles);
		return this;
	}

	@Override
	public Long getID() {

		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

	@Override
	public List<String> getRoles() {
		return new ArrayList<>(roles);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private void setPassword(String password) {
		BCryptPasswordEncoder pwd = new BCryptPasswordEncoder();
		passwordHash = pwd.encode(password);
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return books;
	}

}
