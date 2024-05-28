package ru.gb.ksv.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 512)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public Task( String description, TaskStatus taskStatus) {
        this.description = description;
        this.status = taskStatus;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = (this.createdAt != null) ? this.createdAt : LocalDateTime.now();
    }

}

