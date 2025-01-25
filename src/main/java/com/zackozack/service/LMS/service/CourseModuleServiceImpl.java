package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseModuleDto;
import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.entity.CourseModule;
import com.zackozack.service.LMS.exception.ResourceNotFoundException;
import com.zackozack.service.LMS.repository.CourseModuleRepository;
import com.zackozack.service.LMS.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseModuleServiceImpl implements CourseModuleService{
    private final CourseModuleRepository courseModuleRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<CourseModuleDto> getAllCourseModules(Long courseId) {
        log.info("Fetching all course modules for course with id: {}", courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + courseId)
        );
        List<CourseModule> courseModules = courseModuleRepository.findAllByCourse_Id(courseId);
        return courseModules.stream()
                .map(courseModule -> modelMapper.map(courseModule, CourseModuleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseModuleDto createNewCourseModule(Long courseId, CourseModuleDto courseModuleDto) {
        log.info("Creating new course module for course with id: {}", courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + courseId)
        );
        CourseModule courseModule = modelMapper.map(courseModuleDto, CourseModule.class);
        courseModule.setCourse(course);
        courseModule.setPublished(false);
        courseModule = courseModuleRepository.save(courseModule);
        log.info("Course module created with id: {}", courseModule.getId());
        return modelMapper.map(courseModule, CourseModuleDto.class);
    }

    @Override
    public CourseModuleDto updateCourseModule(Long courseId, Long id, CourseModuleDto courseModuleDto) {
        log.info("Updating course module with id: {} , course id: {}", courseModuleDto.getId(), courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + courseId)
        );
        CourseModule courseModule = courseModuleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course module not found with id: " + id)
        );
        mapDTOtoEntity(courseModuleDto, courseModule);
        courseModule = courseModuleRepository.save(courseModule);
        log.info("Course module updated with id: {}", courseModule.getId());
        return modelMapper.map(courseModule, CourseModuleDto.class);
    }

    @Override
    @Transactional
    public Boolean deleteCourseModule(Long courseId, Long id) {
        log.info("Deleting course module with id: {} , course id: {}", id, courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + courseId)
        );
        Boolean exists = courseModuleRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Course module not found with id: " + id);
        }
        courseModuleRepository.deleteById(id);
        log.info("Course module deleted with id: {}", id);
        return true;
    }

   private void mapDTOtoEntity(CourseModuleDto courseModuleDto, CourseModule courseModule){
        courseModule.setName(courseModuleDto.getName());
        courseModule.setOrderNumber(courseModuleDto.getOrderNumber());
        courseModule.setPublished(courseModuleDto.getPublished());
   }
}
