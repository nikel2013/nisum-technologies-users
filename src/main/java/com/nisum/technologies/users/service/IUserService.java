package com.nisum.technologies.users.service;

import com.nisum.technologies.users.dto.RegisterDTO;
import com.nisum.technologies.users.dto.RegisterResponseDTO;

public interface IUserService {

    /**
     * register
     * 
     * @param register
     * @return RegisterResponseDTO.class
     */		
	RegisterResponseDTO register(RegisterDTO register) throws Exception;
	
}