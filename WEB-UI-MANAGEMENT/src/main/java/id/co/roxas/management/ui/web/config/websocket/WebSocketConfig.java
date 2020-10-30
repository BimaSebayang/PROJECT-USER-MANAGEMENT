package id.co.roxas.management.ui.web.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import id.co.roxas.management.ui.web.controller.BaseCtl;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends BaseCtl implements WebSocketMessageBrokerConfigurer{

		@Override
	    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
	        stompEndpointRegistry.addEndpoint("/ws")
	                .setAllowedOrigins("*")
	                .withSockJS()
	                .setClientLibraryUrl(
	                        "https://cdn.jsdelivr.net/sockjs/latest/sockjs.min.js")
	                      .setInterceptors(new HttpSessionHandshakeInterceptor());;
	    }

	    @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.enableSimpleBroker(TOPIC);
	        registry.setApplicationDestinationPrefixes(APP);
	    }
	    
}
