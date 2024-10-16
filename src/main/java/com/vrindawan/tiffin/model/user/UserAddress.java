package com.vrindawan.tiffin.model.user;

import com.vrindawan.tiffin.dto.UserAddressDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "UserAddresses")
@Data
@NoArgsConstructor
public class UserAddress {

    @Id
    private String id;

    @NonNull
    private String street;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String postalCode;

    @NonNull
    private String country;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    private LocalDateTime updatedAt;

    public static UserAddress fromDto(UserAddressDTO userAddressDto) {
        UserAddress userAddress = new UserAddress();
        userAddress.id = userAddressDto.getId();
        userAddress.street = userAddressDto.getStreet();
        userAddress.city = userAddressDto.getCity();
        userAddress.state = userAddressDto.getState();
        userAddress.postalCode = userAddressDto.getPostalCode();
        userAddress.country = userAddressDto.getCountry();
        userAddress.createdAt = LocalDateTime.now();
        userAddress.updatedAt = LocalDateTime.now();
        return userAddress;
    }

    public UserAddressDTO toDto() {
        UserAddressDTO dto = new UserAddressDTO();
        dto.setId(this.id);
        dto.setStreet(this.street);
        dto.setCity(this.city);
        dto.setState(this.state);
        dto.setPostalCode(this.postalCode);
        dto.setCountry(this.country);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        return dto;
    }

    public UserAddress copyWith(UserAddress address) {
        UserAddress userAddress = new UserAddress();
        userAddress.street = address.getStreet() != null ? address.getStreet() : this.street;
        userAddress.city = address.getCity() != null ? address.getCity() : this.city;
        userAddress.state = address.getState() != null ? address.getState() : this.state;
        userAddress.postalCode = address.getPostalCode() != null ? address.getPostalCode() : this.postalCode;
        userAddress.country = address.getCountry() != null ? address.getCountry() : this.country;
        userAddress.updatedAt = LocalDateTime.now();
        return userAddress;
    }

}
