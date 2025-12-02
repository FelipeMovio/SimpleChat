package com.felipemovio.chat.DTO.response;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegisterResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;

}
