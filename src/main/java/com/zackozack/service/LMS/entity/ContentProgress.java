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
@Table(name = "content_progress", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "content_id"})
})
public class ContentProgress {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
        @ManyToOne
        @JoinColumn(name = "content_id", nullable = false)
        private ModuleContent content;
        private Boolean completed;
        @Min(0)
        @Max(100)
        private Integer progressPercentage;
}
