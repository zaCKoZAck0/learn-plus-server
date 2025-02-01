package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseModuleDto;

import java.util.List;

public interface CourseModuleService {
    List<CourseModuleDto> getAllCourseModules(Long courseId);
    CourseModuleDto createNewCourseModule(Long courseId, CourseModuleDto courseModuleDto);
    CourseModuleDto updateCourseModule(Long id, CourseModuleDto courseModuleDto);
    CourseModuleDto publishCourseModule(Long id);
    Boolean deleteCourseModule(Long id);
}
