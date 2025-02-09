package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.CourseDto;
import com.zackozack.service.LMS.dto.EnrollmentDto;
import com.zackozack.service.LMS.dto.UserDto;
import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.entity.Enrollment;
import com.zackozack.service.LMS.entity.User;
import com.zackozack.service.LMS.exception.ResourceNotFoundException;
import com.zackozack.service.LMS.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{
    private final EnrollmentRepository enrollmentRepository;
    private final UserService userService;
    private final CourseService courseService;
    private final ModelMapper modelMapper;
    @Override
    public List<EnrollmentDto> getAllEnrollmentsForCourse(Long courseId) {
        log.info("Fetching all enrollments for course with id: {}", courseId);
        List<Enrollment> enrollments = enrollmentRepository.findAllByCourse_Id(courseId);
        return enrollments.stream()
                .map(enrollment -> modelMapper.map(enrollment, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDto> getAllEnrollmentsForUser(Long userId) {
        log.info("Fetching all enrollments for user with id: {}", userId);
        List<Enrollment> enrollments = enrollmentRepository.findAllByUser_Id(userId);
        return enrollments.stream()
                .map(enrollment -> modelMapper.map(enrollment, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentDto createNewEnrollment(Long courseId, Long userId) {
        log.info("Creating new enrollment for course with id: {} and user with id: {}", courseId, userId);
        UserDto user = userService.getUserById(userId);
        CourseDto course = courseService.getCourseById(courseId);
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(modelMapper.map(course, Course.class));
        enrollment.setUser(modelMapper.map(user, User.class));
        enrollment = enrollmentRepository.save(enrollment);
        log.info("Enrollment created with id: {}", enrollment.getId());
        return modelMapper.map(enrollment, EnrollmentDto.class);
    }

    @Override
    public EnrollmentDto getEnrollmentById(Long id) {
        log.info("Fetching enrollment with id: {}", id);
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Enrollment not found with id: " + id)
        );
        return modelMapper.map(enrollment, EnrollmentDto.class);
    }

    @Override
    public Boolean deleteEnrollment(Long id) {
        log.info("Deleting enrollment with id: {}", id);
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Enrollment not found with id: " + id)
        );
        enrollmentRepository.delete(enrollment);
        log.info("Enrollment deleted with id: {}", id);
        return true;
    }
}
