package com.fausto.agendador_tarefas.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private String email;
	private String password;
}