package org.example.demo.study.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.demo.study.domain.enums.Role;
import org.example.demo.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        Integer gender;
        @NotBlank
        Integer birthYear;
        @NotBlank
        Integer birthMonth;
        @NotBlank
        Integer birthDay;
        @NotBlank
        Integer age;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotBlank
        Role role;
        @ExistCategories
        List<Long> preferCategory;
    }
}
