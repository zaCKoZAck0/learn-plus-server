package com.zackozack.service.LMS.repository;

import com.zackozack.service.LMS.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course[] findAllByInstructor_Id(Long instructorId);
}
