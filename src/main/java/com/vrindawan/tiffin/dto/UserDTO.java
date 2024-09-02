package com.vrindawan.tiffin.dto;

import com.vrindawan.tiffin.model.location.Location;
import com.vrindawan.tiffin.model.user.UserRole;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

public class UserDTO {


    @NotNull(message = "User id can not be null")
    private String uid;


    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Number cannot be null")
    private Long number;

    @NotNull(message = "Role cannot be null, Select from USER OR ADMIN")
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
}
