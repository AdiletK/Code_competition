package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.config.jwt.JwtTokenUtil;
import com.knu.code_competition.code_competition.model.JwtRequest;
import com.knu.code_competition.code_competition.model.JwtResponse;
import com.knu.code_competition.code_competition.model.Message;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.service.UserService;
import com.knu.code_competition.code_competition.service.impl.JwtUserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/")
@RestController
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsServiceImpl userDetailsService;

    private final UserService userService;

    private final Message message;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsServiceImpl userDetailsService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.message = new Message("The login is already exists");
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername().toLowerCase(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("register")
    public ResponseEntity<?> saveUser(@RequestBody UserModel user) {
        try {
            return ResponseEntity.ok(userDetailsService.save(user));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(message);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
