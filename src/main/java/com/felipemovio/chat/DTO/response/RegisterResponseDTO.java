package com.felipemovio.chat.DTO.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class RegisterResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;

}
