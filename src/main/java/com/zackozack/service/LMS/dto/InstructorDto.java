package com.zackozack.service.LMS.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InstructorDto {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
}
