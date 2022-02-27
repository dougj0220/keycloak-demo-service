package io.doug.keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KeycloakServiceApplication {

	public static final String API_ROOT = "/api/v1";
	public static final String USER_API = API_ROOT + "/user";

	public static ApplicationContext APPLICATION_CONTEXT;

	public static void main(String[] args) {
		APPLICATION_CONTEXT = SpringApplication.run(KeycloakServiceApplication.class, args);
	}
}
