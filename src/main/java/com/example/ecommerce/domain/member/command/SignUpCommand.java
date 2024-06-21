package com.example.ecommerce.domain.member.command;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.domain.member.entity.member.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpCommand {

    private String username;
    private String password;
    private ProfileCommand profile;
    private AddressCommand address;

    public static SignUpCommand of(SignUpRequest request) {
        if (request == null) return new SignUpCommand();
        return SignUpCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .profile(ProfileCommand.of(request.getProfile()))
                .address(AddressCommand.of(request.getAddress()))
                .build();
    }

    public static Member toEntity(SignUpCommand command) {
        if (command == null) return new Member();
        return Member.builder()
                .username(command.username)
                .password(command.password)
                .profile(ProfileCommand.toProfile(command.profile))
                .address(AddressCommand.toAddress(command.address))
                .build();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProfileCommand {

        private String name;
        private String email;
        private String phoneNum;

        public static ProfileCommand of(SignUpRequest.ProfileRequest request) {
            if (request == null) return new ProfileCommand();
            return ProfileCommand.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phoneNum(request.getPhoneNum())
                    .build();
        }

        public static Profile toProfile(ProfileCommand command) {
            if (command == null) return new Profile();
            return Profile.builder()
                    .name(command.name)
                    .email(command.email)
                    .phoneNum(command.phoneNum)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressCommand {
        
        private String city;
        private String street;

        public static AddressCommand of(SignUpRequest.AddressRequest request) {
            if (request == null) return new AddressCommand();
            return AddressCommand.builder()
                    .city(request.getCity())
                    .street(request.getStreet())
                    .build();
        }

        public static Address toAddress(AddressCommand command) {
            if (command == null) return new Address();
            return Address.builder()
                    .city(command.city)
                    .street(command.street)
                    .build();
        }
    }
}
