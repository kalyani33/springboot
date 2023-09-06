package com.example.springboot.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "UserDto Model")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Schema(description = "User Firstname")
    @NotEmpty(message = "User Firstname must not be null/empty")
    private String firstname;

    @Schema(description = "User LastName")
    @NotEmpty(message = "User LastName must not be null/empty")
    private String lastname;

    @Schema(description = "User Email")
    @NotEmpty(message = "User Email must not be empty")
    @Email(message = "Email should be valid")
    private String email;


}
