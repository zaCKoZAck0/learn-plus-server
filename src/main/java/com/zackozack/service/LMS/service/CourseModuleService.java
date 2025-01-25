package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseModuleDto;

import java.util.List;

public interface CourseModuleService {
    List<CourseModuleDto> getAllCourseModules(Long courseId);
    CourseModuleDto createNewCourseModule(Long courseId, CourseModuleDto courseModuleDto);
    CourseModuleDto updateCourseModule(Long courseId, Long id, CourseModuleDto courseModuleDto);
    Boolean deleteCourseModule(Long courseId, Long id);
}
