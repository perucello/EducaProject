package com.educaciencia.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciencia.demo.entities.User;
import com.educaciencia.demo.repositories.UserRepository;

//select
@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repository;
	
	//metodo - select all
	public List<User> findAll(){
		return repository.findAll();
	}	
	
	//Metodo - select por ID
	public User findById(Long id) {
		Optional<User> obj =  repository.findById(id);
		return obj.get();	
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
