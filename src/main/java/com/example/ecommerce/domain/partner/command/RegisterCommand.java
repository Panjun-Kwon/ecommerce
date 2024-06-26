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

    public static RegisterCommand of(RegisterRequest request) {
        if (request == null) return new RegisterCommand();
        return RegisterCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .profile(ProfileCommand.of(request.getProfile()))
                .build();
    }

    public Partner toPartner() {
        if (this == null) return new Partner();
        return new Partner(this.username, this.password, this.profile.toProfile());
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProfileCommand {

        private String name;
        private String email;
        private String phoneNum;
        private AddressCommand address;

        public static ProfileCommand of(RegisterRequest.ProfileRequest request) {
            if (request == null) return new ProfileCommand();
            return ProfileCommand.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phoneNum(request.getPhoneNum())
                    .address(AddressCommand.of(request.getAddress()))
                    .build();
        }

        public Profile toProfile() {
            if (this == null) return new Profile();
            return Profile.builder()
                    .name(this.name)
                    .email(this.email)
                    .phoneNum(this.phoneNum)
                    .address(this.address.toAddress())
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
            return new AddressCommand(request.getCity(), request.getStreet());
        }

        public Address toAddress() {
            if (this == null) return new Address();
            return new Address(this.city, this.street);
        }
    }
}
