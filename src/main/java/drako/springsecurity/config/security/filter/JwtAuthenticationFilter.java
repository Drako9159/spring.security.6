package drako.springsecurity.config.security.filter;

import drako.springsecurity.entity.User;
import drako.springsecurity.repository.IUserRepository;
import drako.springsecurity.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1. Obtener el header que contiene el jwt
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        //2. Obtener jwt desde el header
        String jwt = authHeader.split(" ")[1];

        //3. Obtener subject/username desde jwt
        String username = jwtService.extractUsername(jwt);

        //4. Setear un objecto Authentication dentro del SecurityContext
        User user = iUserRepository.findByUsername(username).get();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        //5. Ejecutar el resto de filtros
        filterChain.doFilter(request, response);

    }
}
