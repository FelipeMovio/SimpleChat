package com.felipemovio.chat.DTO.request;


import com.felipemovio.chat.model.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String nome;


    private Integer idade;


    private String email;


    private String senha;

    private Role role;
}
