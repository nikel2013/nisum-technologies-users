package com.nisum.technologies.users.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nisum.technologies.users.dto.RegisterDTO;
import com.nisum.technologies.users.dto.RegisterResponseDTO;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "A través de este módulo podemos administrar los usuarios de la plataforma")
@RequestMapping("/users")
@OpenAPIDefinition(info = @Info(title = "API - Users", 
description = "Contiene los servicios necesarios para administrar los Usuarios de Nisum Technologies",
version = "v1",
contact = @Contact(name = "Elkin Daza",
                   email = "elkin.daza@hotmail.es",
                   url = "https://www.linkedin.com/in/elkin-daza/"
				  )
	)

)
public interface IUserController {

	@RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
    		description = "Registra un usuario en el sistema",
            summary = "Este servicio permite crear un nuevo usuario en Nisum Technologies",
            parameters = { @Parameter(name = "RegisterDTO",
            						  description = "Contiene la información de la operación",
            						  style = ParameterStyle.FORM,
            						  in = ParameterIn.QUERY,
            	                      example = "{\r\n"
            	                      		+ "  \"name\": Elkin,\r\n"
            	                      		+ "  \"email\": \"elkin.daza@nisum.com\",\r\n"
            	                      		+ "  \"password\": \"Pass123*\",\r\n"
            	                      		+ "  \"phones\": \"[ { \"number\": \"1234567\",\r\n"
            	                      		+ "  \"citycode\": \"1\",\r\n"
            	                      		+ "  \"contrycode\": \"57\" } ]\",\r\n"            	                      		
            	                      		+ "}")
    					}
    		)
			public ResponseEntity<RegisterResponseDTO> register(@RequestBody @Valid final RegisterDTO request) throws Exception;
}