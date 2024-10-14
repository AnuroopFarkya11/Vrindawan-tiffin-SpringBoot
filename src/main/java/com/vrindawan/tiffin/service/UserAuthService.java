package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.model.user.UserEntity;
import com.vrindawan.tiffin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername invoked");
        log.info("loadUserByUsername user name : " + username);
        long parsedNumber = Long.parseLong(username);
        log.info("loadUserByUsername parsed number : " + parsedNumber);


        Optional<UserEntity> optionalUser = repository.findByphoneNumber(parsedNumber);

        if (optionalUser.isEmpty()) {
            log.info("loadUserByUsername user not found: " + parsedNumber);

            throw new UsernameNotFoundException("User not found with number " + parsedNumber);
        }
        UserEntity userEntity = optionalUser.get();
        log.info("loadUserByUsername user found : name " + userEntity.getName());

        return User.builder()
                .username(userEntity.getPhoneNumber().toString())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole().toString())
                .build();
    }

    /*public UserDetails loadUserByNumber(Long number) throws UsernameNotFoundException{
        log.info("loadUserByNumber invoked");

        Optional<UserEntity> userEntityOptional = repository.findByPhoneNumber(number);

        if(userEntityOptional.isEmpty())
        {
            throw  new UsernameNotFoundException("User not found with number " + number);
        }
        UserEntity userEntity = userEntityOptional.get();

        return User.builder()
                .username(userEntity.getPhoneNumber().toString())
                .password(userEntity.getPassword())
                .build();
    }

*/


}
