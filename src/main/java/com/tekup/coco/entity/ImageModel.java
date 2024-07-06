package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String filePath;
    @Lob
    @Column(length = 999999999)
    private byte[] bytes;

    public ImageModel(byte[] bytes, String filePath) {
        this.bytes = bytes;
        this.filePath = filePath;
    }
}
