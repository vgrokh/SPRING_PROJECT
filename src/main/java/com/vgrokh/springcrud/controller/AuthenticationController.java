package com.vgrokh.springcrud.controller;

import com.vgrokh.springcrud.model.User;
import com.vgrokh.springcrud.repository.UserRepository;
import com.vgrokh.springcrud.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO requestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword()));
        User user  = userRepository.findUserByEmail(requestDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        String token = jwtTokenProvider.createToken(requestDTO.getEmail(), user.getRole().name());
        Map<Object, Object> response = new HashMap<>();
        response.put("email", requestDTO.getEmail());
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }



}
