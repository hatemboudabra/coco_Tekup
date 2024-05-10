package com.tekup.coco.Controller;

import com.tekup.coco.Dto.MessageDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
@Controller
public class ChatController {
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public MessageDto chat(@DestinationVariable String roomId, MessageDto message) {
        System.out.println(message);
        return new MessageDto(message.getMessage(), message.getUser());
    }
}
