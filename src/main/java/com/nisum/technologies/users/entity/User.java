package com.nisum.technologies.users.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.nisum.technologies.users.domain.Constants.Database;
import com.nisum.technologies.users.domain.Constants.Field;

@Entity
@Table(name = Database.USER_TABLE, uniqueConstraints={@UniqueConstraint(name = "uk_email", columnNames = {Field.USER_EMAIL})})
public class User extends Audit{

	@Id
	@Column(name = Field.USER_ID)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	private UUID id;
	
	@Column(name = Field.USER_NAME)
	private String name;
	
	@Column(name = Field.USER_PASSWORD)
	private String password;
	
	@Column(name = Field.USER_EMAIL)
	private String email;
	
	@Column(name = Field.USER_TOKEN)
	private String token;
	
	@Column(name = Field.USER_LAST_LOGIN)
	@CreationTimestamp
	private Date lastLogin;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, targetEntity = Phone.class)
	private List<Phone> phones;
	
	public User() {
		
	}
	
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}	
}