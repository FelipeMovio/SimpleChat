package com.felipemovio.chat.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // Para mensagens que o servidor vai enviar para os clientes
        registry.enableSimpleBroker("/topic", "/queue");

        // Para mensagens que o cliente envia para o servidor
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // Permitir front-end no dev
                .withSockJS(); // Habilitar fallback SockJS
    }
}
