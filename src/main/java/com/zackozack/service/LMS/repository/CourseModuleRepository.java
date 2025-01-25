package com.zackozack.service.LMS.repository;

import com.zackozack.service.LMS.dto.CourseModuleDto;
import com.zackozack.service.LMS.entity.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseModuleRepository extends JpaRepository<CourseModule, Long>{
    List<CourseModule> findAllByCourse_Id(Long courseId);
}
