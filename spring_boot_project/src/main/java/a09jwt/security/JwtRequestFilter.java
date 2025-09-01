package a09jwt.security;

import a09jwt.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

    @Component
    public class JwtRequestFilter extends OncePerRequestFilter {

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private MyUserDetailsService userDetailsService;

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain) throws ServletException, IOException {
            final String authHeader = request.getHeader("Authorization");

            String username = null;
            String jwt = null;

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwt = authHeader.substring(7);
                try {
                    username = jwtUtil.extractUsername(jwt);
                } catch (ExpiredJwtException e) {
                    logger.warn("JWT expired");
                }
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = this.userDetailsService.loadUserByUsername(username);

                if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
                    var authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            chain.doFilter(request, response);
        }


    }



