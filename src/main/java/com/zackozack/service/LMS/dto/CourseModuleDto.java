package com.zackozack.service.LMS.dto;

import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.entity.ModuleContent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CourseModuleDto {
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;
    @NotBlank(message = "Order number is required")
    @Min(1)
    private Integer orderNumber;
    private List<ModuleContentDto> contents;
    private Boolean published;
}
