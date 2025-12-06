package com.felipemovio.chat.controller;

import com.felipemovio.chat.DTOs.ChatInputDTO;
import com.felipemovio.chat.DTOs.ChatOutputDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutputDTO message(ChatInputDTO input){
        return new ChatOutputDTO(HtmlUtils.htmlEscape(input.user() + " : " + input.message()));
    }
}
