package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class NewPasswordDTO {

	@NotBlank(message = "Campo obrigatório")
	private String token;

	@NotBlank(message = "Campo obrigatório")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$", message = "A senha deve conter pelo menos uma letra maiúscula e um caractere especial, e ter no mínimo 8 caracteres")
	private String password;

	public NewPasswordDTO() {
	}

	public NewPasswordDTO(String token, String password) {
		this.token = token;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
