package com.example.e_commerce.application.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserRegisterDto {

    @Email(message = "must be valid")
    @NotBlank(message ="email is required")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private  String Password;

    @NotBlank(message = "Name is required")
    private String name;
}
