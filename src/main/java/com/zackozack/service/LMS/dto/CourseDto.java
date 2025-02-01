package com.zackozack.service.LMS.dto;

import com.zackozack.service.LMS.entity.User;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseDto {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "Instructor is required")
    private InstructorDto instructor;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double priceInUSD;

    private Integer durationInHours;

    private Boolean published;
}