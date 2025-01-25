package com.zackozack.service.LMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "module_quizzes")
public class ModuleQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean graded;
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private Double passingGradePercentage;
    @Min(0)
    private Integer timeLimitMinutes;
    private Boolean shuffleQuestions;
    private Boolean shuffleAnswers;
    private Boolean showCorrectAnswersAtEnd;
    private Boolean unlimitedRetries;
    @Min(0)
    private Integer maxRetries;
    @OneToOne
    @JoinColumn(name = "course_module_id", nullable = false)
    private Course courseModule;
}
