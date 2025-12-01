package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTO.ChatMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessageDTO send(ChatMessageDTO message) {
        return message;
    }
}
