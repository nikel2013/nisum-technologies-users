package com.nisum.technologies.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nisum.technologies.users.domain.Constants.Database;
import com.nisum.technologies.users.domain.Constants.Field;

@Entity
@Table(name = Database.PPHONE_TABLE)
public class Phone extends Audit{

	@Id
	@Column(name = Field.PHONE_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@Column(name = Field.PHONE_NUMBER)
	private String number;
	
	@Column(name = Field.CITY_CODE)
	private String cityCode;
	
	@Column(name = Field.COUNTRY_CODE)
	private String countryCode;
	
	public Phone() {
		
	}
	
	public Phone(String number, String cityCode, String countryCode) {
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}	
}