package com.zackozack.service.LMS.dto;

import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnrollmentDto {
    private Long id;
    @NotNull(message = "User is required")
    private User user;
    @NotNull(message = "Course is required")
    private Course course;
    private LocalDateTime enrolledAt;
}
