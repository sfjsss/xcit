package com.projectshadow.xcit.entity;

import com.projectshadow.xcit.model.Visibility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @NotNull
    private Visibility visibility;

    @NotNull
    private boolean isOriginal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDate createdAt;

    public Post() {
    }

    public Post(long id, String description, @NotNull Visibility visibility, @NotNull boolean isOriginal, LocalDate createdAt) {
        this.id = id;
        this.description = description;
        this.visibility = visibility;
        this.isOriginal = isOriginal;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public void setOriginal(boolean original) {
        isOriginal = original;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                isOriginal == post.isOriginal &&
                Objects.equals(description, post.description) &&
                visibility == post.visibility &&
                Objects.equals(createdAt, post.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, visibility, isOriginal, createdAt);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                ", isOriginal=" + isOriginal +
                ", createdAt=" + createdAt +
                '}';
    }
}
