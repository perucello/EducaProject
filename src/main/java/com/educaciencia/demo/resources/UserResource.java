package com.educaciencia.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaciencia.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//Teste em Jasob localhost:8080/users
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "TesteNome", "testeEmail", "testePhone", "testePassword");
				return ResponseEntity.ok().body(u);
	}
	
}
