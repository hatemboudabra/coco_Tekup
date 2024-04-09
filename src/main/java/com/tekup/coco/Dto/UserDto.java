package com.tekup.coco.Dto;

import com.tekup.coco.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class UserDto {
    private String username;
    private String email;
    private String password;
    private int announcementCount;

    private List<ReclamationDto> reclamationDtoList;
public  UserDto(){}
    public UserDto(String username, String email, String password, int announcementCount, List<ReclamationDto> reclamationDtoList) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.announcementCount = announcementCount;
        this.reclamationDtoList = reclamationDtoList;
    }

/*
    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
            //throw an exception
        }

        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
            // TODO throw an exception
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());


        return user;
    }

 */
}
