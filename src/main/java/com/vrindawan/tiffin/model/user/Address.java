package com.vrindawan.tiffin.model.user;

import com.vrindawan.tiffin.dto.AddressDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "UserAddresses")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Address {

    @Id
    private ObjectId id;

    private String addressId = new ObjectId().toHexString();

    @NonNull
    private String name;

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
    private String phoneNumber;

    private String alternatePhoneNumber;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    private LocalDateTime updatedAt;

    public static Address fromDto(AddressDTO addressDto) {
        Address address = new Address();
        address.id = addressDto.getId();
        address.addressId = addressDto.getAddressId();
        address.name = addressDto.getName();
        address.street = addressDto.getStreet();
        address.city = addressDto.getCity();
        address.state = addressDto.getState();
        address.postalCode = addressDto.getPostalCode();
        address.country = addressDto.getCountry();
        address.phoneNumber = addressDto.getPhoneNumber();
        address.alternatePhoneNumber = addressDto.getAlternatePhoneNumber();
        address.createdAt = LocalDateTime.now();
        address.updatedAt = LocalDateTime.now();
        return address;
    }

    public AddressDTO toDto() {
        AddressDTO dto = new AddressDTO();
        dto.setId(this.id);
        dto.setAddressId(this.addressId);
        dto.setName(this.name);
        dto.setStreet(this.street);
        dto.setCity(this.city);
        dto.setState(this.state);
        dto.setPostalCode(this.postalCode);
        dto.setCountry(this.country);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setAlternatePhoneNumber(this.alternatePhoneNumber);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        return dto;
    }

    public Address copyWith(Address address) {
        Address userAddress = new Address();
        userAddress.name = address.getName() != null ? address.getName() : this.name;
        userAddress.street = address.getStreet() != null ? address.getStreet() : this.street;
        userAddress.city = address.getCity() != null ? address.getCity() : this.city;
        userAddress.state = address.getState() != null ? address.getState() : this.state;
        userAddress.postalCode = address.getPostalCode() != null ? address.getPostalCode() : this.postalCode;
        userAddress.country = address.getCountry() != null ? address.getCountry() : this.country;
        userAddress.phoneNumber = address.getPhoneNumber()!=null?address.getPhoneNumber():this.phoneNumber;
        userAddress.alternatePhoneNumber = address.getAlternatePhoneNumber()!=null?address.getAlternatePhoneNumber():this.alternatePhoneNumber;
        userAddress.updatedAt = LocalDateTime.now();
        return userAddress;
    }

}
