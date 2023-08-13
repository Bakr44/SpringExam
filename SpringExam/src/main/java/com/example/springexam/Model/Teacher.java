package com.example.springexam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "id Teacher should be not empty")
    private Integer id;
    @NotEmpty(message = "Name Teacher should be not empty")
    private String name;
    @NotNull(message = "Salary should be not empty")
    private Integer salary;
}
