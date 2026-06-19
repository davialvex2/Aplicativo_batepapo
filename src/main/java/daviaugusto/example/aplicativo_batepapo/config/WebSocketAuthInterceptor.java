package daviaugusto.example.aplicativo_batepapo.config;


import daviaugusto.example.aplicativo_batepapo.secutiry.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class WebSocketAuthInterceptor implements ChannelInterceptor {


    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public Message<?> preSend(Message<?> message,
                              MessageChannel channel) {

        StompHeaderAccessor accessor =
                MessageHeaderAccessor.getAccessor(
                        message,
                        StompHeaderAccessor.class);

        System.out.println("COMANDO: " + accessor.getCommand());
        System.out.println("USUARIO ATUAL: " + accessor.getUser());

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {

            String bearer = accessor.getFirstNativeHeader("Authorization");

            System.out.println("TOKEN RECEBIDO: " + bearer);

            if (bearer != null && bearer.startsWith("Bearer ")) {
                String token = bearer.substring(7);

                String username = jwtUtil.extrairEmailToken(token);

                System.out.println("USUARIO JWT: " + username);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,
                                null,
                                Collections.emptyList()
                        );

                accessor.setUser(auth);

                System.out.println("USER APOS SET: " + accessor.getUser());
            }
        }

        return message;
    }



}
