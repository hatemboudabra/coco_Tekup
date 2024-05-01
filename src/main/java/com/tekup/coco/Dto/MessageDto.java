package com.tekup.coco.Dto;

import com.tekup.coco.entity.enummeration.MessageType;
import lombok.*;

@Data
@AllArgsConstructor
public class MessageDto {
    String message;
    String user;
}
