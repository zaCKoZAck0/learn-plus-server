package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseDto;
import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.exception.ResourceNotFoundException;
import com.zackozack.service.LMS.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<CourseDto> getAllCourses() {
        log.info("Fetching all courses");
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public CourseDto createNewCourse(CourseDto courseDto) {
        log.info("Creating new course with title: {} for instructor {} : {}", courseDto.getTitle(), courseDto.getInstructor().getId(), courseDto.getInstructor().getName());
        Course course = modelMapper.map(courseDto, Course.class);
        course.setPublished(false);
        course.setDurationInHours(0);
        course = courseRepository.save(course);
        log.info("Course created with id: {}", course.getId());
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        log.info("Fetching course with id: {}", id);
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );
        return modelMapper.map(course, CourseDto.class);
    }



    @Override
    public CourseDto[] getAllCoursesByInstructor(Long instructorId) {
        log.info("Fetching course with instructor id: {}", instructorId);
        Course[] courses = courseRepository.findAllByInstructor_Id(instructorId);
        return modelMapper.map(courses, CourseDto[].class);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        log.info("Updating course with id: {}", id);
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );
        courseDto.setId(id);
        modelMapper.map(courseDto, course);
        course = courseRepository.save(course);
        log.info("Course updated with id: {}", course.getId());
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public Boolean deleteCourse(Long id) {
        log.info("Deleting course with id: {}", id);
        Boolean exists = courseRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
        log.info("Course deleted with id: {}", id);
        // Todo: Delete all course materials
        return true;
    }

    @Override
    public CourseDto publishCourse(Long id) {
        log.info("Publishing course with id: {}", id);
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );
        course.setPublished(true);
        course = courseRepository.save(course);
        log.info("Course published with id: {}", course.getId());
        return modelMapper.map(course, CourseDto.class);
    }
    @Override
    public CourseDto archiveCourse(Long id) {
        log.info("Archiving course with id: {}", id);
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );
        course.setPublished(false);
        course = courseRepository.save(course);
        log.info("Course archived with id: {}", course.getId());
        return modelMapper.map(course, CourseDto.class);
    }
}
