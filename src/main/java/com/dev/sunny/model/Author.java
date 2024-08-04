package com.dev.sunny.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private List<String> publications;

    public Author(String name, String email, List<String> publications) {
        this.name = name;
        this.email = email;
        this.publications = publications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
