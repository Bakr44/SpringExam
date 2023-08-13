package com.example.springexam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "id should be not empty")
    private Integer id;
    @NotEmpty(message = "Name should be not empty")
    private String name;
    @NotNull(message = "Age should be not empty")
    private Integer age;
    @NotEmpty(message = "Major should be not empty")
    private String major;

}
