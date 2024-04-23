package com.tekup.coco.Dto;

import com.tekup.coco.entity.enummeration.MessageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private MessageType type;
    private String content;
    private String sender;
}
