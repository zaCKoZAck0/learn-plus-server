package com.zackozack.service.LMS.repository;

import com.zackozack.service.LMS.dto.EnrollmentDto;
import com.zackozack.service.LMS.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
    List<Enrollment> findAllByCourse_Id(Long courseId);

    List<Enrollment> findAllByUser_Id(Long userId);
}
