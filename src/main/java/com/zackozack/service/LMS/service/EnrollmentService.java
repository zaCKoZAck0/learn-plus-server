package com.zackozack.service.LMS.service;


import com.zackozack.service.LMS.dto.EnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentDto> getAllEnrollmentsForCourse(Long courseId);
    List<EnrollmentDto> getAllEnrollmentsForUser(Long userId);
    EnrollmentDto createNewEnrollment(Long courseId, Long userId);
    EnrollmentDto getEnrollmentById(Long id);
    Boolean deleteEnrollment(Long id);
}
