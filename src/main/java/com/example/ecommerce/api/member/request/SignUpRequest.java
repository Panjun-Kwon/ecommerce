package com.example.ecommerce.api.member.request;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class SignUpRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Valid
    @NotNull
    private ProfileRequest profile;

    @Getter
    public static class ProfileRequest {
        @NotNull
        private String name;
        @Email
        private String email;
        private String phoneNum;
        private AddressRequest address;
    }

    @Getter
    public static class AddressRequest {
        private String city;
        private String street;
    }
}
