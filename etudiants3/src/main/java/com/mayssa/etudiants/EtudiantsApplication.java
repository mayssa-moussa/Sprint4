package com.mayssa.etudiants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Role;
import com.mayssa.etudiants.entities.User;
import com.mayssa.etudiants.service.EtudiantService;
import com.mayssa.etudiants.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EtudiantsApplication implements CommandLineRunner{
	
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	PasswordEncoder passwordEncoder;


	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(EtudiantsApplication.class, args);
	}
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"mayssa","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("mayssa", "USER");
	userService.addRoleToUser("mayssa", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/

	@Override
	public void run(String... args) throws Exception {
	//repositoryRestConfiguration.exposeIdsFor(Etudiant.class);
		//System.out.println("Password Encoded BCRYPT :******************** ");
		 //System.out.println(passwordEncoder.encode("123"));
	}

	/*@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaiss = null;
        try {
            dateNaiss = dateFormat.parse("14/07/2003");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		 etudiantService.saveEtudiant(new Etudiant("abidi","ahmed",dateNaiss,"bizerte","ahmed.abidi@gmail.com",2022,"GC"));
		 etudiantService.saveEtudiant(new Etudiant("makhlouf","sami",dateNaiss,"nabeul","sami@gmail.com",2023,"IT"));
		 etudiantService.saveEtudiant(new Etudiant("sfia","salma",dateNaiss,"tunis","salma@gmail.com",2024,"DM"));
		
	}*/

}
