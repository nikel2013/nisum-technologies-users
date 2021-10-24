package com.nisum.technologies.users.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.technologies.users.domain.Constants.Field;
import com.nisum.technologies.users.domain.Constants.Error;

import io.swagger.v3.oas.annotations.media.Schema;

@Validated
public class RegisterDTO {
	
	@Schema(description = Field.USER_NAME, required = true, example = "Elkin")
	@JsonProperty(Field.USER_NAME)
	@NotNull(message = Error.DTO_USER_NAME)
	@NotEmpty(message = Error.DTO_USER_NAME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)	
	private String name;
	
	@Schema(description = Field.USER_EMAIL, required = true, example = "elkin.daza@nisum.com")
	@JsonProperty(Field.USER_EMAIL)
	@NotNull(message = Error.DTO_USER_EMAIL)
	@NotEmpty(message = Error.DTO_USER_EMAIL)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Pattern(regexp = "^(.+)@(.+)$", message = Error.DTO_FORMAT_USER_EMAIL)
	private String email;

	@Schema(description = Field.USER_PASSWORD, required = true)
	@JsonProperty(Field.USER_PASSWORD)
	@NotNull(message = Error.DTO_USER_PASSWORD)
	@NotEmpty(message = Error.DTO_USER_PASSWORD)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String password;
	
	@Schema(description = Field.USER_PHONES, required = false)
	@JsonProperty(Field.USER_PHONES)
	@NotNull(message = Error.DTO_PHONE_NUMBER)
	@NotEmpty(message = Error.DTO_PHONE_NUMBER)
	private List<PhoneDTO> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
}