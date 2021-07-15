package ch.zli.m223.ksh18a.niclug.crm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Crm1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crm1Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder gPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
