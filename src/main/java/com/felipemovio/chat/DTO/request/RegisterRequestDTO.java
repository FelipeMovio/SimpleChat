package com.felipemovio.chat.DTO.request;


import com.felipemovio.chat.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterRequestDTO {
    @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    private Role role;
}
