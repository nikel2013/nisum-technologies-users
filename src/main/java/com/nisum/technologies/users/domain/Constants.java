package com.nisum.technologies.users.domain;

public class Constants {
	
	public static class Security{
		
		public static final String SECRET = "NisumTechnologies";
		public static final Integer EXPIRATION_DATE = 1;
		
	}
	
	public static class Database{
		
		public static final String USER_TABLE = "user";
		public static final String PPHONE_TABLE = "phone";
		
	}

	public static class Field{
		
		public static final String USER_ID = "id";
		public static final String USER_NAME = "name";
		public static final String USER_EMAIL = "email";
		public static final String USER_PASSWORD = "password";
		public static final String USER_TOKEN = "token";
		public static final String USER_LAST_LOGIN = "last_login";
		public static final String USER_PHONES = "phones";

		public static final String PHONE_ID = "id";
		public static final String PHONE_NUMBER = "number";
		public static final String CITY_CODE = "citycode";
		public static final String COUNTRY_CODE = "countrycode";
		
		public static final String AUDIT_ACTIVE = "active";
		public static final String AUDIT_CREATED = "created";
		public static final String AUDIT_MODIFIED = "modified";
		
	}
	
	public static class Info {
		
		public static final String SUCCESSFUL = "�Operaci�n exitosa!";
				
	}
		
	public static class Error{
		
		public static final String DTO_USER_NAME = "Indique el nombre del usuario";		
		public static final String DTO_USER_EMAIL = "Escriba un email";
		public static final String DTO_FORMAT_USER_EMAIL = "Escriba un email con formato v�lido";
		public static final String DTO_USER_PASSWORD = "Especifique una contrase�a";
		
		public static final String DTO_PHONE_NUMBER = "Indique un n�mero telef�nico";
		public static final String DTO_CITY_CODE = "Indique un citycode";
		public static final String DTO_COUNTRY_CODE = "Indique un countrycode";
		
		public static final String ALREADY_EXISTS_USER = "Ya existe un usuario con email: %s";
	}
}
