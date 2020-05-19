package com.educaciencia.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaciencia.demo.entities.User;
import com.educaciencia.demo.repositories.UserRepository;

@Configuration
@Profile("test") //nome igual ao do Profile para rodar teste no perfil de teste
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//Executar quando o Programa for iniciado - implementando classe CommandLine
		//instanciando Objetos e Salvando no Banco de Dados
		User u1 = new User(null, "TesteNome1", "teste1@gmail.com", "999999999", "1234");
		User u2 = new User(null, "TesteNome2", "teste2@gmail.com", "888888888", "1234");
		
		//Para salvar no BD
		userRepository.saveAll(Arrays.asList(u1, u2));

		
	}
	
	
}
