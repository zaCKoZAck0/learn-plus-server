package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    CourseDto createNewCourse(CourseDto courseDto);
    CourseDto getCourseById(Long id);
    CourseDto[] getAllCoursesByInstructor(Long id);
    CourseDto updateCourse(Long id, CourseDto courseDto);
    Boolean deleteCourse(Long id);
    CourseDto publishCourse(Long id);
    CourseDto archiveCourse(Long id);
}
