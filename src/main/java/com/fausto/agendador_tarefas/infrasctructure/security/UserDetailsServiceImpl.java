package com.fausto.agendador_tarefas.infrasctructure.security;

import com.elder.usuario.infrastructure.entity.Users;
import com.elder.usuario.infrastructure.repository.UserRepository;
import com.fausto.agendador_tarefas.business.dto.UserDTO;
import com.fausto.agendador_tarefas.infrasctructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
	@Autowired
	private UserClient client;
	
	public UserDetails loadUserData(String email, String token) {
		UserDTO userDTO = client.findUsersEmail(email, token);
		
		return User
						.withUsername(userDTO.getEmail()) // Define o nome de usuário como o e-mail
						.password(userDTO.getPassword()) // Define a senha do usuário
						.build(); // Constrói o objeto UserDetails
	}
}
