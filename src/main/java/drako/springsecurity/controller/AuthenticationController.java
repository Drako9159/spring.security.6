package drako.springsecurity.controller;

import drako.springsecurity.dto.AuthenticationRequest;
import drako.springsecurity.dto.AuthenticationResponse;
import drako.springsecurity.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/public-access")
    public ResponseEntity<String> publicAccessEndpoint() {
        return ResponseEntity.ok("Este endpoint es una prueba");
    }

}
