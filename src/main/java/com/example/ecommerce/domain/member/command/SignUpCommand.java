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

    public static SignUpCommand of(SignUpRequest request) {
        if (request == null) return new SignUpCommand();

        return SignUpCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .profile(ProfileCommand.of(request.getProfile()))
                .build();
    }

    public Member toMember() {
        if (this == null) return new Member();

        return Member.builder()
                .username(this.username)
                .password(this.password)
                .profile(this.profile.toProfile())
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
        private AddressCommand address;

        public static ProfileCommand of(SignUpRequest.ProfileRequest request) {
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
                    .address(this.getAddress().toAddress())
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

        public Address toAddress() {
            if (this == null) return new Address();

            return Address.builder()
                    .city(this.city)
                    .street(this.street)
                    .build();
        }
    }
}
