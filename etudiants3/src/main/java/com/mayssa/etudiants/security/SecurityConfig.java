package com.mayssa.etudiants.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

	private final DataSource dataSource;

	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/showCreate", "/saveEtudiant")
				.hasAnyAuthority("ADMIN", "AGENT").requestMatchers("/modifierEtudiant", "/supprimerEtudiant")
				.hasAuthority("ADMIN").requestMatchers("/ListeEtudiants").hasAnyAuthority("ADMIN", "AGENT", "USER")
				.requestMatchers("/login", "/webjars/**").permitAll().anyRequest().authenticated())
				// .formLogin(Customizer.withDefaults())
				.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/"))
				.httpBasic(Customizer.withDefaults())
				.exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
		userDetailsManager.setDataSource(dataSource);
		userDetailsManager.setUsersByUsernameQuery("select username, password, enabled from user where username = ?");
		userDetailsManager.setAuthoritiesByUsernameQuery(
				"SELECT u.username, r.role as authority " + "FROM user_role ur, user u, role r "
						+ "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?");
		return userDetailsManager;
	}*/
}
