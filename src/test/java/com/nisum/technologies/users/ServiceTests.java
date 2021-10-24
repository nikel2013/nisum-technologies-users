package com.nisum.technologies.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.nisum.technologies.users.controller.UserController;
import com.nisum.technologies.users.domain.Constants.Error;
import com.nisum.technologies.users.domain.Constants.Field;
import com.nisum.technologies.users.domain.Constants.Info;
import com.nisum.technologies.users.dto.BaseResponseDTO;
import com.nisum.technologies.users.dto.PhoneDTO;
import com.nisum.technologies.users.dto.RegisterDTO;
import com.nisum.technologies.users.dto.RegisterResponseDTO;
import com.nisum.technologies.users.entity.User;
import com.nisum.technologies.users.repository.IUserRepository;
import com.nisum.technologies.users.security.JwtService;
import com.nisum.technologies.users.service.UserService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ServiceTests {
	
	@Mock
    private RestTemplate restTemplate;	

	@Mock
	private IUserRepository userRepository;
	
	@InjectMocks
	private JwtService jwtService;	
	
	@InjectMocks
	private UserService userService = new UserService(mock(JwtService.class));
	
	@InjectMocks
	private UserController userController = new UserController(userService);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}
	
	@Test
	void register() throws Exception {
		
		RegisterDTO request = new RegisterDTO();
		request.setName(Field.USER_NAME);		
		request.setPassword(Field.USER_PASSWORD);
		request.setEmail(Field.USER_EMAIL);
		
		List<PhoneDTO> phones = new ArrayList<>();
		PhoneDTO p = new PhoneDTO();
		p.setNumber(Field.PHONE_NUMBER);
		p.setCityCode(Field.CITY_CODE);
		p.setCountryCode(Field.COUNTRY_CODE);
		phones.add(p);
		
		request.setPhones(phones);
		
		RegisterResponseDTO response = new RegisterResponseDTO();

		User u = mock(User.class);		
		when(userService.existsUser(u)).thenReturn(false);
		when(userService.getToken(u)).thenReturn(Field.USER_TOKEN);
				
		response = userService.register(request);
		assertEquals(HttpStatus.OK, response.getStatusCode());		
		assertEquals(Info.SUCCESSFUL, response.getMensaje());		
		assertNull(response.getId());
		assertNull(response.getCreated());
		assertNull(response.getModified());
		assertNull(response.getLastLogin());
		assertNull(response.getToken());
		assertTrue(response.getIsactive());
	}
	
	@Test
	void existsUser() {
		
		RegisterDTO request = mock(RegisterDTO.class);
		User u = mock(User.class);
		
		when(userService.existsUser(u)).thenReturn(true);
		
		Exception eService = assertThrows(
		           Exception.class,
		           () -> userService.register(request));		
		assertEquals(String.format(Error.ALREADY_EXISTS_USER, u.getEmail()), eService.getMessage());
	}
	
	@Test
	void getToken() {
		User u = new User(Field.USER_NAME, Field.USER_PASSWORD, Field.USER_EMAIL);
		Map<String, Object> claims = new HashMap<>();
		claims.put(Field.USER_EMAIL, u.getEmail());				
		
		String token = jwtService.create(u.getName(), claims);
		assertNotNull(token);
	}	
	
	@Test
	void testResponse() {
		BaseResponseDTO response = new BaseResponseDTO();
		response.setStatusCode(HttpStatus.BAD_REQUEST);
		response.setMensaje(Error.DTO_USER_NAME);		
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(Error.DTO_USER_NAME, response.getMensaje());
	}
}