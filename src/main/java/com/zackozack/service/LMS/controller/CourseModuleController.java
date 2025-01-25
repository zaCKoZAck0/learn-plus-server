package com.zackozack.service.LMS.controller;

import com.zackozack.service.LMS.dto.CourseModuleDto;
import com.zackozack.service.LMS.service.CourseModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseModuleController {
    private final CourseModuleService courseModuleService;
    @GetMapping("/{courseId}/modules")
    public ResponseEntity<List<CourseModuleDto>> getAllCourses(@PathVariable Long courseId) {
        List<CourseModuleDto> courseModuleDtos = courseModuleService.getAllCourseModules(courseId);
        return new ResponseEntity<>(courseModuleDtos, HttpStatus.OK);
    }
    @PostMapping("/{courseId}/modules")
    public ResponseEntity<CourseModuleDto> createCourseModule(@PathVariable Long courseId, @RequestBody CourseModuleDto courseModuleDto) {
        CourseModuleDto newCourseModule = courseModuleService.createNewCourseModule(courseId, courseModuleDto);
        return new ResponseEntity<>(newCourseModule, HttpStatus.CREATED);
    }
}
