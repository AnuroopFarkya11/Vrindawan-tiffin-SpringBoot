package com.vrindawan.tiffin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserAddressDTO {

    private String id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}