package com.vrindawan.tiffin.dto;

import com.vrindawan.tiffin.model.location.Location;
import com.vrindawan.tiffin.model.order.OrderEntity;
import com.vrindawan.tiffin.model.user.UserRole;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {


    @NotNull(message = "User id can not be null")
    private String uid;


    @NotEmpty(message = "Name cannot be empty")
    private String name;

//    @NotEmpty(message = "Username cannot be empty")
    private String userName;

//    @NotEmpty(message = "Address cannot be empty")
    private List<AddressDTO> addresses= new ArrayList<>();

    @NotNull(message = "Number cannot be null")
    private Long phoneNumber;

    @NotNull(message = "Password cannot be null")
    private String password;


    @NotNull(message = "Role cannot be null, Select from USER OR ADMIN")
    private UserRole role;
    private Location location;

    private List<OrderEntity> orderEntities = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
