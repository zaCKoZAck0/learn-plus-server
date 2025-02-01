package com.zackozack.service.LMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quiz_options", uniqueConstraints = @UniqueConstraint(columnNames = {"question_id", "option_number"}))
public class QuizOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;
    private Integer optionNumber;
    private String optionText;
    private Boolean correct;
    private String explanation;
    private String image;
}
