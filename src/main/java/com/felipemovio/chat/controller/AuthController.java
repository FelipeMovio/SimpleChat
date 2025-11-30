package com.felipemovio.chat.controller;


import com.felipemovio.chat.DTO.request.LoginRequestDTO;
import com.felipemovio.chat.DTO.request.RegisterRequestDTO;
import com.felipemovio.chat.DTO.response.LoginResponseDTO;
import com.felipemovio.chat.DTO.response.RegisterResponseDTO;
import com.felipemovio.chat.model.UserEntity;
import com.felipemovio.chat.security.TokenConfig;
import com.felipemovio.chat.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody @Valid RegisterRequestDTO dto) {
        RegisterResponseDTO user = authService.register(dto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuário registrado com sucesso!");
        response.put("data", user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid  LoginRequestDTO dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha())
        );
        UserEntity user = (UserEntity) auth.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}

