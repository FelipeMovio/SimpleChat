package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTO.ChatMessageInputDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessageInputDTO send(ChatMessageInputDTO message) {
        return message;
    }
}
