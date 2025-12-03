package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTO.request.ChatMessageInputDTO;
import com.felipemovio.chat.DTO.response.ChatMessageOutputDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessageOutputDTO send(ChatMessageInputDTO input, Principal principal) {

        String username = principal.getName();

        return new ChatMessageOutputDTO(username + ": " + input.getMessage());
    }
}
