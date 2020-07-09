package com.projectshadow.xcit.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private boolean disableComments;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDate createdAt;

    public Project() {
    }

    public Project(long id, @NotNull String title, @NotNull String description, @NotNull boolean disableComments, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.disableComments = disableComments;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisableComments() {
        return disableComments;
    }

    public void setDisableComments(boolean disableComments) {
        this.disableComments = disableComments;
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
        Project project = (Project) o;
        return id == project.id &&
                disableComments == project.disableComments &&
                Objects.equals(title, project.title) &&
                Objects.equals(description, project.description) &&
                Objects.equals(createdAt, project.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, disableComments, createdAt);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", disableComments=" + disableComments +
                ", createdAt=" + createdAt +
                '}';
    }
}
