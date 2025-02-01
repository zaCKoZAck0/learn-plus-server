package com.zackozack.service.LMS.entity;

import com.zackozack.service.LMS.entity.enums.QuizQuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quiz_questions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"questionNumber", "module_quiz_id"})
})
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer questionNumber;
    @NotBlank
    @Column(nullable = false)
    private String questionStatement;
    @Column(nullable = false)
    private Integer marks;
    @Column(nullable = false)
    private Integer negativeMarks;
    @Column(nullable = false)
    private Boolean multipleCorrectAnswers;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizQuestionType questionType;
    @ManyToOne
    @JoinColumn(name = "module_quiz_id", nullable = false)
    private ModuleQuiz moduleQuiz;
}