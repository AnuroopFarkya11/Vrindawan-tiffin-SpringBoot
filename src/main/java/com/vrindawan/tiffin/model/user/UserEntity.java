package com.vrindawan.tiffin.model.user;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.model.location.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Users")
public class UserEntity {

    @Id
    private String uid;
    private String name;
    private String address;
    private Long number;
    private UserRole role;
    private Location location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public String getUid() {
        return uid;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static UserEntity fromDto(UserDTO userDto) {
        UserEntity user = new UserEntity();
        user.uid = userDto.getUid();
        user.name = userDto.getName();
        user.address = userDto.getAddress();
        user.number = userDto.getNumber();
        user.role = userDto.getRole();
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    public UserDTO toDto() {
        UserDTO dto = new UserDTO();
        dto.setUid(this.uid);
        dto.setName(this.name);
        dto.setAddress(this.address);
        dto.setNumber(this.number);
        dto.setRole(this.role);
        dto.setLocation(this.location);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        return dto;
    }

    public UserEntity copyWith(UserEntity entity) {
        UserEntity user = new UserEntity();

        user.name = entity.getName() != null ? entity.getName() : this.name;
        user.address = entity.getAddress() != null ? entity.getAddress() : this.address;
        user.role = entity.getRole() != null ? entity.getRole() : this.role;
        user.updatedAt = LocalDateTime.now();
        return user;
    }

}
