package com.vrindawan.tiffin.dto;

import com.vrindawan.tiffin.model.location.Location;
import com.vrindawan.tiffin.model.user.UserRole;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDTO {


    @NotNull(message = "User id can not be null")
    private String uid;


    @NotEmpty(message = "Name cannot be empty")
    private String name;

//    @NotEmpty(message = "Username cannot be empty")
    private String userName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Number cannot be null")
    private Long number;

    @NotNull(message = "Password cannot be null")
    private String password;


    @NotNull(message = "Role cannot be null, Select from USER OR ADMIN")
    private UserRole role;

    private Location location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
