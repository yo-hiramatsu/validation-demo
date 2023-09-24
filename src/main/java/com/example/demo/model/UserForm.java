package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class UserForm {
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthday;
	@NotBlank
	@Size(min=8, max = 16)
	private String password;
}
