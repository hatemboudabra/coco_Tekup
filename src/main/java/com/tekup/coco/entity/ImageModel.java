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
    @Lob // Annotation utilisée pour indiquer que la colonne stocke de grandes valeurs binaires
    @Column(length = 999999999)
    private byte[] bytes;


    public ImageModel(byte[] bytes, String name, String Type) {

        this.bytes = bytes;

    }
}
