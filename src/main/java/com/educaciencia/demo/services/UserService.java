package com.educaciencia.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciencia.demo.entities.User;
import com.educaciencia.demo.repositories.UserRepository;
import com.educaciencia.demo.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));	
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);//para monitorar o Objeto e depois efetuar operação no Banco de Dados(melhor nque FindAllId)
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
