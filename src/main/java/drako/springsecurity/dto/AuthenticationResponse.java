package drako.springsecurity.dto;

public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt) {

        this.jwt = jwt;
    }


}
