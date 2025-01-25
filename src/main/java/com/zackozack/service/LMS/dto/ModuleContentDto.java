package com.zackozack.service.LMS.dto;

import com.zackozack.service.LMS.entity.enums.ContentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class ModuleContentDto {
    private Long id;
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    @NotBlank(message = "Order number is required")
    private Integer orderNumber;
    @NotBlank(message = "Content URL is required")
    @URL(message = "Content URL must be a valid URL")
    private String contentUrl;
    @NotBlank(message = "Content type is required")
    private ContentType contentType;
}
