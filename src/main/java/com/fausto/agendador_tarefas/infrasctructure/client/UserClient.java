package com.fausto.agendador_tarefas.infrasctructure.client;

import com.fausto.agendador_tarefas.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UserClient {
	
	@GetMapping("/user")
	UserDTO findUsersEmail(@RequestParam("email") String email,
	                       @RequestParam("Authorization") String token);
}
