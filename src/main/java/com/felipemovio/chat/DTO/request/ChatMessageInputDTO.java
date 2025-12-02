package com.felipemovio.chat.DTO.request;

import com.felipemovio.chat.model.UserEntity;
import lombok.Data;

@Data
public class ChatMessageInputDTO {
    private UserEntity user;
    private String message;
}
