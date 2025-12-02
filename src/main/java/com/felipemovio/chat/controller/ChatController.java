package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTO.request.ChatMessageInputDTO;
import com.felipemovio.chat.DTO.response.ChatMessageOutputDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessageOutputDTO send(ChatMessageInputDTO inputDTO) {
        return new ChatMessageOutputDTO(inputDTO.getUser() + ":" + inputDTO.getMessage());
    }
}
