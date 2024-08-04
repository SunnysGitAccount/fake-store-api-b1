package com.dev.sunny.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "publishing_date")
    private LocalDateTime publishedAt;

    @Column(name = "updated_date")
    private LocalDateTime updatedAt;
}
