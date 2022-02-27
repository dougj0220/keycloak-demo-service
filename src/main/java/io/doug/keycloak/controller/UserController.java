package io.doug.keycloak.controller;

import io.doug.keycloak.KeycloakServiceApplication;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping(KeycloakServiceApplication.USER_API)
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Value("${hello.txt}")
    private String appText;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getAnonymous() {
        LOG.info("returning some stuff here for anonymous open API endpoint...");
        return ResponseEntity.ok("keycloak-service: " + appText);
    }

    @RolesAllowed("user")
    @GetMapping(value = "/app-user")
    public ResponseEntity<String> getUser(@RequestHeader String Authorization) {
        //Authentication auth;
        //Principal principal;
        LOG.info("returning all user data for auth token: {}", Authorization);
        return ResponseEntity.ok("Hello App User");
    }

    @RolesAllowed("admin")
    @GetMapping(value = "/admin")
    public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {
        LOG.info("returning admin user data for auth token: {}", Authorization);
        return ResponseEntity.ok("Hello App Admin");
    }

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/super-user")
    public ResponseEntity<String> getSuperuser(@RequestHeader String Authorization) {

        LOG.info("returning super user data for auth token: {}", Authorization);
        return ResponseEntity.ok("Hello App Super User");
    }
}
