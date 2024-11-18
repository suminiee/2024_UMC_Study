package org.example.demo.study.dto;

import lombok.Getter;
import org.example.demo.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        Integer age;
        String address;
        String specAddress;
        String email;
        @ExistCategories
        List<Long> preferCategory;
    }
}
