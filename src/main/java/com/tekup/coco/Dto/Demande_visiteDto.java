package com.tekup.coco.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Demande_visiteDto {
    private Date rendez_vous;
    private String status;
    private  Long userId;
    private Long collocationId;
}
