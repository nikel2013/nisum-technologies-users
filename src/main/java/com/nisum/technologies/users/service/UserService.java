package com.nisum.technologies.users.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.technologies.users.domain.Constants.Error;
import com.nisum.technologies.users.domain.Constants.Field;
import com.nisum.technologies.users.dto.PhoneDTO;
import com.nisum.technologies.users.dto.RegisterDTO;
import com.nisum.technologies.users.dto.RegisterResponseDTO;
import com.nisum.technologies.users.entity.Phone;
import com.nisum.technologies.users.entity.User;
import com.nisum.technologies.users.repository.IUserRepository;
import com.nisum.technologies.users.security.JwtService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
		
	public UserService(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	public RegisterResponseDTO register(RegisterDTO register) throws Exception {
			
		final RegisterResponseDTO response = new RegisterResponseDTO();
		final User u = new User();
		fillUser(u, register);
		if(existsUser(u)) {
			throw new Exception(String.format(Error.ALREADY_EXISTS_USER, u.getEmail()));			
		}else {			
			u.setToken(getToken(u));
			userRepository.save(u);	
			
			response.setId(u.getId());
			response.setCreated(u.getCreated());
			response.setModified(u.getModified());
			response.setIsactive(u.isActive());
			response.setToken(u.getToken());
			response.setLastLogin(u.getLastLogin());
			
			return response;			
		}
	}
	
	public Boolean existsUser(final User u) {
		if(userRepository.existsByEmail(u.getEmail())) {
			return true;
		}
		
		return false;
	}
	
	private void fillUser(final User u, RegisterDTO register) {
		u.setName(register.getName());
		u.setEmail(register.getEmail());
		u.setPassword(register.getPassword());
		u.setPhones(getPhonesToAdd(u, register.getPhones()));
	}
	
	private List<Phone> getPhonesToAdd(final User u, final List<PhoneDTO> lista) {
		List<Phone> phones = new ArrayList<>();
		if(lista != null) {
			for(PhoneDTO item: lista) {
				Phone p = new Phone();
				p.setUser(u);
				p.setNumber(item.getNumber());
				p.setCityCode(item.getCityCode());
				p.setCountryCode(item.getCountryCode());
				
				phones.add(p);
			}
		}
		return phones;		
	}
	
	public String getToken(final User u) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(Field.USER_EMAIL, u.getEmail());		
		return jwtService.create(u.getName(), claims);
	}
}