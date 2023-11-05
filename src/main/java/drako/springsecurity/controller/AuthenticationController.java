package drako.springsecurity.controller;

import drako.springsecurity.dto.AuthenticationRequest;
import drako.springsecurity.dto.AuthenticationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        return null;
    }

    @GetMapping("/public-access")
    public ResponseEntity<String> publicAccessEndpoint() {
        return ResponseEntity.ok("Este endpoint es una prueba");
    }

}
