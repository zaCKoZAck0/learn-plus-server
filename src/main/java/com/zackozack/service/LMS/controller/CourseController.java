package com.zackozack.service.LMS.controller;

import com.zackozack.service.LMS.dto.CourseDto;
import com.zackozack.service.LMS.dto.CourseModuleDto;
import com.zackozack.service.LMS.service.CourseModuleService;
import com.zackozack.service.LMS.service.CourseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseModuleService courseModuleService;
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courseDtos = courseService.getAllCourses();
        return new ResponseEntity<>(courseDtos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto newCourse = courseService.createNewCourse(courseDto);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long id) {
        CourseDto course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        CourseDto updatedCourse = courseService.updateCourse(id, courseDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Long id) {
        Boolean isDeleted = courseService.deleteCourse(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
//      return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/publish")
    public ResponseEntity<CourseDto> publishCourse(@PathVariable Long id) {
        CourseDto publishedCourse = courseService.publishCourse(id);
        return new ResponseEntity<>(publishedCourse, HttpStatus.OK);
    }
    @PatchMapping("/{id}/archive")
    public ResponseEntity<CourseDto> archiveCourse(@PathVariable Long id) {
        CourseDto archivedCourse = courseService.archiveCourse(id);
        return new ResponseEntity<>(archivedCourse, HttpStatus.OK);
    }
    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<CourseDto[]> getAllCoursesFromInstructor(@PathVariable Long instructorId) {
        CourseDto[] courseDtos = courseService.getAllCoursesByInstructor(instructorId);
        return new ResponseEntity<>(courseDtos, HttpStatus.OK);
    }
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
