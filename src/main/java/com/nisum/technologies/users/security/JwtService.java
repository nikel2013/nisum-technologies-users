package com.nisum.technologies.users.security;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.nisum.technologies.users.domain.Constants.Security;
import com.nisum.technologies.users.utils.Dates;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService implements IJwtService{	

	@Override
	public String create(String subject, Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, Security.SECRET)
                .setIssuedAt(Dates.getCurrentDate())
                .setExpiration(Dates.addToCurrentDate(Security.EXPIRATION_DATE))
                .compact();
	}
}