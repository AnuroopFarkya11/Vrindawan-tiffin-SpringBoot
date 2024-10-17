package com.vrindawan.tiffin.model.user;

import com.vrindawan.tiffin.dto.AddressDTO;
import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.model.location.Location;
import com.vrindawan.tiffin.model.order.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
@NoArgsConstructor
public class

UserEntity {

    @Id
    private String uid;

    @NonNull
    private String name;


    private String userName;

    @DBRef
    private List<Address> addresses=new ArrayList<>();

    @NonNull
    @Indexed(unique = true)
    private Long phoneNumber;

    @NonNull
    private String password;
    @NonNull
    private UserRole role;
    private Location location;

    @DBRef
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private LocalDateTime updatedAt;

    public static UserEntity fromDto(UserDTO userDto) {
        List<Address> userAddresses = userDto.getAddresses().stream().map(Address::fromDto).toList();

        UserEntity user = new UserEntity();
        user.uid = userDto.getUid();
        user.name = userDto.getName();
        user.userName = userDto.getUserName();
        user.addresses = userAddresses;
        user.phoneNumber = userDto.getPhoneNumber();
        user.password = userDto.getPassword();
        user.role = userDto.getRole();
        user.orderEntities = userDto.getOrderEntities();
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    public UserDTO toDto() {

        List<AddressDTO> addressDTOS = this.addresses.stream().map(Address::toDto).toList();

        UserDTO dto = new UserDTO();
        dto.setUid(this.uid);
        dto.setName(this.name);
        dto.setUserName(this.userName);
        dto.setAddresses(addressDTOS);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setPassword(this.password);
        dto.setRole(this.role);
        dto.setOrderEntities(this.orderEntities);
        dto.setLocation(this.location);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        return dto;
    }

    public UserEntity copyWith(UserEntity entity) {
        UserEntity user = new UserEntity();

        user.name = entity.getName() != null ? entity.getName() : this.name;
        user.userName = entity.getUserName() != null ? entity.getUserName() : this.userName;
        user.addresses = entity.getAddresses() != null ? entity.getAddresses() : this.addresses;
        user.role = entity.getRole() != null ? entity.getRole() : this.role;
        user.updatedAt = LocalDateTime.now();
        user.password = entity.getPassword() != null ? entity.getPassword() : this.password;
        return user;
    }

}
