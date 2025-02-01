package com.zackozack.service.LMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_modules")
public class CourseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer orderNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    private Boolean published;
    @OneToMany(mappedBy = "courseModule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("orderNumber ASC")
    private List<ModuleContent> contents;
    @OneToOne
    private ModuleQuiz quiz;
}
