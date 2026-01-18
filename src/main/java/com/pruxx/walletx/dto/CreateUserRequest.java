package com.pruxx.walletx.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotBlank
    @Size(max = 120)
    public String name;

    @NotBlank
    @Email
    @Size(max = 255)
    public String email;
}
