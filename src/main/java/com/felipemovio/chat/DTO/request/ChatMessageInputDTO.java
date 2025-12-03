package com.felipemovio.chat.DTO.request;

import com.felipemovio.chat.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChatMessageInputDTO {
    private String message;
}
