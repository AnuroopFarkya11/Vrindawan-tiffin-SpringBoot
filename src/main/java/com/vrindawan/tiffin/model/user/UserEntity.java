package com.vrindawan.tiffin.model.user;

import com.vrindawan.tiffin.dto.UserDTO;
import com.vrindawan.tiffin.model.location.Location;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    private String uid;

    @NonNull
    private String name;


    private String userName;

    @NonNull
    private String address;
    @NonNull
    @Indexed(unique = true)
    private Long number;
    @NonNull
    private String password;
    @NonNull
    private UserRole role;
    private Location location;
    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private LocalDateTime updatedAt;

    public static UserEntity fromDto(UserDTO userDto) {
        UserEntity user = new UserEntity();
        user.uid = userDto.getUid();
        user.name = userDto.getName();
        user.userName = userDto.getUserName();
        user.address = userDto.getAddress();
        user.number = userDto.getNumber();
        user.password = userDto.getPassword();
        user.role = userDto.getRole();
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    public UserDTO toDto() {
        UserDTO dto = new UserDTO();
        dto.setUid(this.uid);
        dto.setName(this.name);
        dto.setUserName(this.userName);
        dto.setAddress(this.address);
        dto.setNumber(this.number);
        dto.setPassword(this.password);
        dto.setRole(this.role);
        dto.setLocation(this.location);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        return dto;
    }

    public UserEntity copyWith(UserEntity entity) {
        UserEntity user = new UserEntity();

        user.name = entity.getName() != null ? entity.getName() : this.name;
        user.userName = entity.getUserName()!=null?entity.getUserName():this.userName;
        user.address = entity.getAddress() != null ? entity.getAddress() : this.address;
        user.role = entity.getRole() != null ? entity.getRole() : this.role;
        user.updatedAt = LocalDateTime.now();
        user.password = entity.getPassword()!=null?entity.getPassword():this.password;
        return user;
    }

}
