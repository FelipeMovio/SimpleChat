package com.felipemovio.chat.DTO.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String senha;
}
