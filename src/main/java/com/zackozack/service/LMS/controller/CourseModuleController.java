package com.zackozack.service.LMS.controller;

import com.zackozack.service.LMS.dto.CourseModuleDto;
import com.zackozack.service.LMS.service.CourseModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseModuleController {
    private final CourseModuleService courseModuleService;
    @PutMapping("/{courseId}/modules/{moduleId}")
    public ResponseEntity<CourseModuleDto> updateCourseModule(@PathVariable Long moduleId, @RequestBody CourseModuleDto courseModuleDto) {
        CourseModuleDto updatedCourseModule = courseModuleService.updateCourseModule(moduleId, courseModuleDto);
        return new ResponseEntity<>(updatedCourseModule, HttpStatus.OK);
    }
    @PatchMapping("/{courseId}/modules/{moduleId}/publish")
    public ResponseEntity<CourseModuleDto> publishCourseModule(@PathVariable Long moduleId) {
        CourseModuleDto publishedCourseModule = courseModuleService.publishCourseModule(moduleId);
        return new ResponseEntity<>(publishedCourseModule, HttpStatus.OK);
    }
    @DeleteMapping("/{courseId}/modules/{moduleId}")
    public ResponseEntity<Boolean> deleteCourseModule(@PathVariable Long moduleId) {
        Boolean isDeleted = courseModuleService.deleteCourseModule(moduleId);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
