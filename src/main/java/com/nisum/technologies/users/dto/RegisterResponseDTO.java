package com.nisum.technologies.users.dto;

import java.util.Date;
import java.util.UUID;

public class RegisterResponseDTO extends BaseResponseDTO{
	
	private UUID id;
	private Date created;
	private Date modified;
	private Date last_login;	
	private String token;	
	private Boolean isactive;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return last_login;
	}
	public void setLastLogin(Date last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}	
}