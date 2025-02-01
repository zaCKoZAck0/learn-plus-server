package com.zackozack.service.LMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

        @Override
        public final boolean equals(Object o) {
                if (this == o) return true;
                if (o == null) return false;
                Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
                Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
                if (thisEffectiveClass != oEffectiveClass) return false;
                ContentProgress that = (ContentProgress) o;
                return getId() != null && Objects.equals(getId(), that.getId());
        }

        @Override
        public final int hashCode() {
                return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
        }
}
