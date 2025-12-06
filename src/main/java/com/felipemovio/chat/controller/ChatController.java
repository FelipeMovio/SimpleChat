package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTOs.ChatInputDTO;
import com.felipemovio.chat.DTOs.ChatOutputDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/new-message")
    public ChatOutputDTO message(ChatInputDTO input){

    }
}
