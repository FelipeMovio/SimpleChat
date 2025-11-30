package com.felipemovio.chat.services;

import com.felipemovio.chat.DTO.request.RegisterRequestDTO;
import com.felipemovio.chat.DTO.response.RegisterResponseDTO;
import com.felipemovio.chat.model.Role;
import com.felipemovio.chat.model.UserEntity;
import com.felipemovio.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        Role role;
        if (dto.getRole() != null) {
            role = dto.getRole();
        } else {
            role = Role.ROLE_USER;
        }


        UserEntity newUser = UserEntity.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .roles(Set.of(role))
                .build();

        UserEntity saved = userRepository.save(newUser);

        return new RegisterResponseDTO(saved.getId(), saved.getNome(), saved.getIdade(), saved.getEmail());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}



