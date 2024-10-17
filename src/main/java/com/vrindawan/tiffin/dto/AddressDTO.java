package com.vrindawan.tiffin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddressDTO {

    private ObjectId id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}