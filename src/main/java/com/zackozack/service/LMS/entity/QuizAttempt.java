package com.zackozack.service.LMS.entity;

import com.zackozack.service.LMS.entity.enums.QuizAttemptStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quiz_attempts")
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private ModuleQuiz quiz;
    private Integer score;
    @Enumerated(EnumType.STRING)
    @NotNull
    private QuizAttemptStatus status;
    private Boolean passed;
    private Integer attemptNumber;
    @CreationTimestamp
    private LocalDateTime startedAt;
    private LocalDateTime submittedAt;
}
