package org.example.jpareschdl.dto;

import lombok.Getter;
import org.example.jpareschdl.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public UserResponseDto(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
