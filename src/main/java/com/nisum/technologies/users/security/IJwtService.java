package com.nisum.technologies.users.security;

import java.util.Map;

public interface IJwtService {
	
	String create(String subject, Map<String, Object> claims);
	
}
