package com.example.ecommerce.domain.partner.command;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommand {

    private String username;
    private String password;
    private ProfileCommand profile;
    private AddressCommand address;

    public static RegisterCommand of(RegisterRequest request) {
        if (request == null) return new RegisterCommand();
        return RegisterCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .profile(ProfileCommand.of(request.getProfile()))
                .address(AddressCommand.of(request.getAddress()))
                .build();
    }

    public static Partner toPartner(RegisterCommand command) {
        if (command == null) return new Partner();
        return Partner.builder()
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

        public static ProfileCommand of(RegisterRequest.ProfileRequest request) {
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

        public static AddressCommand of(RegisterRequest.AddressRequest request) {
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
