package com.educaciencia.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaciencia.demo.entities.Order;
import com.educaciencia.demo.entities.User;
import com.educaciencia.demo.repositories.OrderRepository;
import com.educaciencia.demo.repositories.UserRepository;

@Configuration
@Profile("test") //nome igual ao do Profile para rodar teste no perfil de teste
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Executar quando o Programa for iniciado - implementando classe CommandLine
		//instanciando Objetos e Salvando no Banco de Dados
		
		
//Salvar User - usuario
		User u1 = new User(null, "TesteNome1", "teste1@gmail.com", "999999999", "1234");
		User u2 = new User(null, "TesteNome2", "teste2@gmail.com", "888888888", "1234");	

		
//Salvar Order - pedido
		Order o1 = new Order(null, Instant.parse("2020-05-18T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-05-19T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2020-05-19T15:21:22Z"), u1);
		
		
		
		//Para salvar no BD
		userRepository.saveAll(Arrays.asList(u1, u2));	
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}
}
